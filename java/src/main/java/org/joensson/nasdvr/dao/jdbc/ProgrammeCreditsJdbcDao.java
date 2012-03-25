package org.joensson.nasdvr.dao.jdbc;

import org.joensson.nasdvr.dao.ProgrammeCreditsRepository;
import org.joensson.nasdvr.model.Actor;
import org.joensson.nasdvr.model.ProgrammeCredits;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: frj
 * Date: 3/25/12
 * Time: 11:13 PM
 *
 * @Author frj
 */
@Component
public class ProgrammeCreditsJdbcDao extends AbstractJdbcRepository<ProgrammeCredits> implements ProgrammeCreditsRepository {

    public List<ProgrammeCredits> fetchAll() {
        List<ProgrammeCredits> results = jdbcTemplate.query("SELECT * FROM programme_credits", rowMapper);
        return results;
    }

    public ProgrammeCredits find(int id) {
        List<ProgrammeCredits> results = jdbcTemplate.query("SELECT * FROM programme_credits WHERE id = ?", rowMapper, id);
        return results.get(0);
    }

    public void save(ProgrammeCredits entity) {
        if (entity.getId() == 0) {
            for (Actor actor : entity.getActors()) {
                //TODO: Check that all actors are in the Actor table
                jdbcTemplate.update("INSERT INTO programme_credits (programme_id, actor_id) VALUES (?, ?)", entity.getProgramme().getId(), actor.getId());
            }

        } else {
            for (Actor actor : entity.getActors()) {
                //TODO: Check that all actors are in the Actor table
                jdbcTemplate.update("UPDATE programme_credits SET programme_id = ?, actor_id = ?", entity.getProgramme().getId(), actor.getId());
            }

        }
    }
}
