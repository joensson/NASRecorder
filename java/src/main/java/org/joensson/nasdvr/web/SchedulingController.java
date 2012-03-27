package org.joensson.nasdvr.web;

import org.joensson.nasdvr.dao.ActorRepository;
import org.joensson.nasdvr.dao.jpa.SchedulerDao;
import org.joensson.nasdvr.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/schedule")
public class SchedulingController {

    @Autowired
    private SchedulerDao schedulerDao;

    @Autowired
    private ActorRepository actorRepository;

    @RequestMapping(value = "createActor",  method = RequestMethod.GET)
    public @ResponseBody List<Actor> createActor() throws MalformedURLException {
        Actor actor = new Actor();
        actor.setActorName("Jackie Chan");
        actor.setCharacterName("Did it work?");
        actorRepository.save(actor);

        actor = new Actor();
        actor.setActorName("Clint Eastwood");
        actor.setCharacterName("...yes it did :-)");
        actorRepository.save(actor);

        return actorRepository.fetchAll();

    }

        @RequestMapping(value = "showSchedule",  method = RequestMethod.GET)
    public @ResponseBody Actor showSchedule(Model model) throws MalformedURLException {
        //TODO


        Category category = new Category();
        category.setName("TV");


        ChannelMap channelMap = new ChannelMap();
        channelMap.setChannelMap("eu-cable");
        channelMap.setDescription("Bla bla");

        Modulation modulation = new Modulation();
        modulation.setModulation("a8qam256");

        Frequency frequency = new Frequency();
        frequency.setChannelMap(channelMap);
        frequency.setFrequency(514000000);
        frequency.setModulation(modulation);
        frequency.setSymbolRate(6875);

        Program program = new Program();
        program.setFrequency(frequency);
        program.setProgram(2030);
        program.setProgramName("TV2 HD");

        Channel channel = new Channel();
        channel.setChannelId("http://ontv.dk/channel/id/100000");
        channel.setDisplayName("TV2 HD");
        channel.setProgram(program);


        Actor actor = new Actor();
        actor.setActorName("Jackie Chan");
        actor.setCharacterName("Some name");

        Actor actor1 = new Actor();
        actor1.setActorName("Johnnie Depp");
        actor1.setCharacterName("Pirate captain");

        List<Actor> actors = new ArrayList<Actor>(2);
        actors.add(actor);
        actors.add(actor1);

        ProgrammeCredits credits = new ProgrammeCredits();
        credits.setActors(actors);

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

        schedulerDao.storeProgram(p);
        return actor;

    }
}
