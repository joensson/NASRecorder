package org.joensson.nasdvr.web;

import org.hibernate.SessionFactory;
import org.joensson.nasdvr.dao.ActorDao;
import org.joensson.nasdvr.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: frj
 * Date: 3/20/12
 * Time: 10:33 AM
 *
 * @Author frj
 */

@Controller
@RequestMapping("/schedule")
public class SchedulingController {

    @Autowired
    private ActorDao actorDao;

    @Autowired SessionFactory sessionFactory;

    @RequestMapping(value = "showSchedule",  method = RequestMethod.GET)
    public @ResponseBody Actor showSchedule(Model model) {
        //TODO
        Actor actor = new Actor();
        actor.setActorName("Jackie Chan");
        actor.setCharacterName("Some name");
        actorDao.storeActor(actor);
        return actor;

    }
}
