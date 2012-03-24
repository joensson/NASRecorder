package org.joensson.nasdvr.web;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.joensson.nasdvr.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: frj
 * Date: 3/21/12
 * Time: 1:41 AM
 *
 * @Author frj
 */
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml", "classpath*:org/joensson/nasdvr/internal/application-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=false)
@Transactional
public class OrmMappingTest {
/*
    private static final String BASE_URL = "http://localhost:8080/nasdvr/rest";

    RestTemplate restTemplate = new RestTemplate();
    @Test
    public void canGetJsonResponseFromController() {
        Actor actor = restTemplate.getForObject(BASE_URL + "/schedule/showSchedule", Actor.class);

        assertNotNull("Actor not found", actor);
    }
*/
    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void checkCategory() {
        Category category = buildCategory();
        sessionFactory.getCurrentSession().save(category);

        assertFalse("EntityId not set", 0 == category.getEntityId());
    }

    @Test
    public void checkChannelMap() {
        ChannelMap channelMap = buildChannelMap();
        sessionFactory.getCurrentSession().save(channelMap);

        assertFalse("EntityId not set", 0 == channelMap.getEntityId());
    }

    @Test
    public void checkModulation() {
        Modulation modulation = buildModulation(buildChannelMap());
        sessionFactory.getCurrentSession().save(modulation);

        assertFalse("EntityId not set", 0 == modulation.getEntityId());
    }

    @Test
    public void checkFrequency() {
        Frequency frequency = buildFrequency(buildChannelMap(), buildModulation(buildChannelMap()));
        sessionFactory.getCurrentSession().save(frequency);

        assertFalse("EntityId not set", 0 == frequency.getEntityId());
    }

    @Test
    public void checkProgram() {
        Program program = buildProgram(buildFrequency(buildChannelMap(), buildModulation(buildChannelMap())));
        sessionFactory.getCurrentSession().save(program);

        assertFalse("EntityId not set", 0 == program.getEntityId());
    }

    @Test
    public void checkChannel() {
        Channel channel = buildChannel(buildProgram(buildFrequency(buildChannelMap(), buildModulation(buildChannelMap()))));
        sessionFactory.getCurrentSession().save(channel);

        assertFalse("EntityId not set", 0 == channel.getEntityId());
    }

    @Test
    public void checkActor() {
        Actor actor = buildActor("Mads Mikkelsen", "Bond bad guy");

        sessionFactory.getCurrentSession().save(actor);

        assertFalse("EntityId not set", 0 == actor.getEntityId());

    }

    @Test
    public void checkProgrammeCredits() throws MalformedURLException {

        ProgrammeCredits credits = buildCredits(buildActors(), buildProgramme(buildCategory(),
                                                                              buildChannel(
                                                                                      buildProgram(
                                                                                              buildFrequency(
                                                                                                      buildChannelMap(),
                                                                                                      buildModulation(
                                                                                                              buildChannelMap())
                                                                                              )
                                                                                      ))
                                                                              ));
        sessionFactory.getCurrentSession().save(credits);

        assertFalse("EntityId not set", 0 == credits.getEntityId());
    }

    @Test
    public void checkProgramme() throws MalformedURLException {
        Programme programme = buildProgramme(buildCategory(),
                                             buildChannel(
                                                     buildProgram(
                                                             buildFrequency(
                                                                     buildChannelMap(),
                                                                     buildModulation(
                                                                             buildChannelMap()
                                                                     )
                                                             )
                                                     )
                                             )
                                );

        sessionFactory.getCurrentSession().save(programme);

        assertFalse("EntityId not set", 0 == programme.getEntityId());
    }


    private Programme buildProgramme(Category category, Channel channel) throws MalformedURLException {
        Programme p = new Programme();
        p.setCategory(category);
        p.setChannel(channel);
        p.setDescription("Hej verden");
        p.setStartTime(new Date());
        p.setEndTime(new Date());
        p.setEpisodeNumber("ep 1");
        p.setIcon(new URL("http://www.google.com"));
        p.setTitle("Title");
        p.setSubTitle("Sub title");
        return p;
    }

    private ProgrammeCredits buildCredits(List<Actor> actors, Programme programme) {
        ProgrammeCredits credits = new ProgrammeCredits();
        credits.setActors(actors);
        credits.setProgramme(programme);
        return credits;
    }

    private List<Actor> buildActors() {
        Actor actor = buildActor("Jackie Chan", "Some hero character");

        Actor actor1 = buildActor("Johnnie Depp", "Jack Sparrow");

        List<Actor> actors = new ArrayList<Actor>(2);
        actors.add(actor);
        actors.add(actor1);
        return actors;
    }

    private Actor buildActor(String actorName, String characterName) {
        Actor actor = new Actor();
        actor.setActorName(actorName);
        actor.setCharacterName(characterName);
        return actor;
    }

    private Channel buildChannel(Program program) {
        Channel channel = new Channel();
        channel.setChannelId("http://ontv.dk/channel/id/100000");
        channel.setDisplayName("TV2 HD");
        channel.setProgram(program);
        return channel;
    }

    private Program buildProgram(Frequency frequency) {
        Program program = new Program();
        program.setFrequency(frequency);
        program.setProgram(2030);
        program.setProgramName("TV2 HD");
        return program;
    }

    private Frequency buildFrequency(ChannelMap channelMap, Modulation modulation) {
        Frequency frequency = new Frequency();
        frequency.setChannelMap(channelMap);
        frequency.setFrequency(514000000);
        frequency.setModulation(modulation);
        frequency.setSymbolRate(6875);
        return frequency;
    }

    private Modulation buildModulation(ChannelMap channelMap) {
        Modulation modulation = new Modulation();
        modulation.setChannelMap(channelMap);
        modulation.setModulation("a8qam256");
        return modulation;
    }

    private ChannelMap buildChannelMap() {
        ChannelMap channelMap = new ChannelMap();
        channelMap.setChannelMap("eu-cable");
        channelMap.setDescription("Bla bla");
        return channelMap;
    }

    private Category buildCategory() {
        Category category = new Category();
        category.setName("TV");
        return category;
    }
}
