package org.joensson.nasdvr.dao;

import org.joensson.nasdvr.model.Actor;

import java.util.List;

/**
 * User: frj
 * Date: 3/24/12
 * Time: 2:03 PM
 *
 * @Author frj
 */
public interface ActorRepository extends NasDvrRepository<Actor> {

    public List<Actor> find(String name);
    public List<Actor> find(String name, String character);

}
