package org.joensson.nasdvr.web;

import org.joensson.nasdvr.dao.*;
import org.joensson.nasdvr.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;

@ContextConfiguration(locations = {"classpath:test-applicationContext.xml", "classpath*:org/joensson/nasdvr/internal/application-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class JdbcDaoTest {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ProgrammeCreditsRepository programmeCreditsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ChannelMapRepository channelMapRepository;

    @Autowired
    private ModulationRepository modulationRepository;

    @Autowired
    private FrequencyRepository frequencyRepository;

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private ProgrammeRepository programmeRepository;

    @Test
    public void insertTest() {

        insertActor();

        insertCategory();

        insertChannelMap();
        int channelMapId = channelMapRepository.fetchAll().get(0).getId();

        insertModulation();

        insertFrequency(channelMapId);

        insertProgram();

        insertChannel();

        insertProgramme();

        insertProgrammeCredits();
    }

    private void insertProgrammeCredits() {
        List<Actor> actors = actorRepository.fetchAll();
        ProgrammeCredits entity = new ProgrammeCredits();
        entity.setProgrammeId(programmeRepository.fetchAll().get(0).getId());
        entity.setActors(actors);
        programmeCreditsRepository.save(entity);
    }

    private void insertProgramme() {
        Programme programme = new Programme();
        programme.setCategoryId(categoryRepository.fetchAll().get(0).getId());
        programme.setChannelId(channelRepository.fetchAll().get(0).getId());
        programme.setDescription("This is a description of the programme");
        programme.setEpisodeNumber("Episode 1");
        programme.setTitle("Top Gear");
        programme.setSubTitle("BBC is fun");
        programme.setStartTime(new Date());
        programme.setEndTime(new Date());
        programmeRepository.save(programme);
    }

    private void insertChannel() {
        Channel channel = new Channel();
        channel.setChannelId("somechannelid");
        channel.setDisplayName("TV2 HD");
        channel.setProgramId(programRepository.fetchAll().get(0).getId());
        channel.setChannelId("some channel id");
        channelRepository.save(channel);
    }

    private void insertProgram() {
        Program program = new Program();
        program.setFrequencyId(frequencyRepository.fetchAll().get(0).getId());
        program.setProgram(2030);
        program.setProgramName("TV2 HD");
        programRepository.save(program);
    }

    private void insertFrequency(int channelMapId) {
        Frequency frequency = new Frequency();
        frequency.setChannelMapId(channelMapId);
        frequency.setFrequency(514000000);
        frequency.setModulationId(modulationRepository.fetchAll().get(0).getId());
        frequency.setSymbolRate(6875);
        frequencyRepository.save(frequency);
    }

    private void insertModulation() {
        Modulation modulation = new Modulation();
        modulationRepository.save(modulation);
    }

    private void insertChannelMap() {
        ChannelMap channelMap = new ChannelMap();
        channelMap.setChannelMap("eu-bcast");
        channelMap.setDescription("some description");
        channelMapRepository.save(channelMap);
    }

    private void insertCategory() {
        Category category = new Category();
        category.setName("TestTest");
        categoryRepository.save(category);
    }

    private void insertActor() {
        Actor actor = new Actor();
        actor.setActorName("Helly Hansen");
        actor.setCharacterName("Bad guy");
        actorRepository.save(actor);
    }

    @Test
    public void updateTest() {
        List<Actor> actors = actorRepository.fetchAll();
        for (Actor actor : actors) {
            actor.setActorName(actor.getActorName() + " updated");
            actor.setCharacterName(actor.getCharacterName() + " updated");
            actorRepository.save(actor);
        }

        List<Category> categories = categoryRepository.fetchAll();
        for (Category category : categories) {
            category.setName(category.getName() + " updated");
            categoryRepository.save(category);
        }

        List<ChannelMap> channelMaps = channelMapRepository.fetchAll();
        for (ChannelMap channelMap : channelMaps) {
            channelMap.setChannelMap(channelMap.getChannelMap() + " updated");
            channelMap.setDescription(channelMap.getDescription() + " updated");
            channelMapRepository.save(channelMap);
        }

        List<Modulation> modulations = modulationRepository.fetchAll();
        for (Modulation modulation : modulations) {
            modulation.setModulation(modulation.getModulation() + " updated");
            modulationRepository.save(modulation);
        }

        List<Frequency> frequencies = frequencyRepository.fetchAll();
        for (Frequency frequency : frequencies) {
            frequency.setFrequency(1111);
            frequency.setSymbolRate(2222);
            frequencyRepository.save(frequency);
        }

        List<Program> programs = programRepository.fetchAll();
        for (Program program : programs) {
            program.setProgram(new Random(9999).nextInt());
            program.setProgramName(program.getProgramName() + " updated");
            programRepository.save(program);
        }

        List<Channel> channels = channelRepository.fetchAll();
        for (Channel channel : channels) {
            channel.setChannelId(channel.getChannelId() + " updated");
            channel.setDisplayName(channel.getDisplayName() + " updated");
            channelRepository.save(channel);
        }

        List<Programme> programmes = programmeRepository.fetchAll();
        for (Programme programme : programmes) {
            programme.setDescription(programme.getDescription() + " updated");
            programme.setEpisodeNumber("Ep 2");
            programme.setSubTitle(programme.getSubTitle() + " updated");
            programme.setTitle(programme.getTitle() + " updated");
            programmeRepository.save(programme);
        }

/*        List<ProgrammeCredits> creditsList = programmeCreditsRepository.fetchAll();
        for (ProgrammeCredits programmeCredits : creditsList) {
            programmeCredits.set
        }*/
    }

}
