package org.joensson.nasdvr.dao.jpa;

import org.hibernate.SessionFactory;
import org.joensson.nasdvr.model.Actor;
import org.joensson.nasdvr.model.Program;
import org.joensson.nasdvr.model.Programme;
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
public class SchedulerDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public void storeProgram(Programme programme) {
        sessionFactory.getCurrentSession().saveOrUpdate(programme);
    }

}
