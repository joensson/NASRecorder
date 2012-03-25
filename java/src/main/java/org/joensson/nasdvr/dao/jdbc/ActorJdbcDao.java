package org.joensson.nasdvr.dao.jdbc;

import org.joensson.nasdvr.dao.ActorRepository;
import org.joensson.nasdvr.model.Actor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: frj
 * Date: 3/24/12
 * Time: 2:02 PM
 *
 * @Author frj
 */
@Component
public class ActorJdbcDao extends AbstractJdbcRepository<Actor> implements ActorRepository {


    public Actor find(int id) {
        List<Actor> results = jdbcTemplate.query("SELECT * FROM actor WHERE id=?", rowMapper, id);

        return results.get(0);
    }

    public List<Actor> find(String name) {
        List<Actor> results = jdbcTemplate.query("SELECT * FROM actor WHERE actor_name=?", rowMapper, name);

        return results;
    }

    public List<Actor> find(String name, String characterName) {
        List<Actor> results = jdbcTemplate.query("SELECT * FROM actor WHERE actor_name=? AND character_name=?", rowMapper, name, characterName);

        return results;
    }

    public void save(Actor actor) {
        if (actor.getEntityId() == 0) {
            jdbcTemplate.update("INSERT INTO actor (actor_name, character_name) VALUES(?, ?)", actor.getActorName(), actor.getCharacterName());
        } else {
            jdbcTemplate.update("UPDATE actor SET actor_name = ? AND  character_name = ?  WHERE id = ?", actor.getActorName(), actor.getCharacterName(), actor.getEntityId());
        }

    }
}
