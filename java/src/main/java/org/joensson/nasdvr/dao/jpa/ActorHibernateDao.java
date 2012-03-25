package org.joensson.nasdvr.dao.jpa;

import org.hibernate.SessionFactory;
import org.joensson.nasdvr.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: frj
 * Date: 3/20/12
 * Time: 2:21 PM
 *
 * @Author frj
 */
@Repository
public class ActorHibernateDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public void storeActor(Actor actor) {
        sessionFactory.getCurrentSession().saveOrUpdate(actor);
    }

}
