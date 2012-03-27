package org.joensson.nasdvr.dao.jdbc;

import org.joensson.nasdvr.dao.ProgrammeCreditsRepository;
import org.joensson.nasdvr.model.Actor;
import org.joensson.nasdvr.model.ProgrammeCredits;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ProgrammeCreditsJdbcDao extends AbstractRowMappingJdbcRepository<ProgrammeCredits> implements ProgrammeCreditsRepository {

    //In this dao multiple rows from the resultset must be mapped to a single domain object, so a ResultSetExtractor is used to wrap the rowMapper
    private RowMapperResultSetExtractor<ProgrammeCredits> resultSetExtractor;

    public ProgrammeCreditsJdbcDao() {
        resultSetExtractor = new RowMapperResultSetExtractor<ProgrammeCredits>(rowMapper);
    }

    public List<ProgrammeCredits> fetchAll() {
        List<ProgrammeCredits> results = new ArrayList<ProgrammeCredits>();

        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT DISTINCT(programme_id) FROM programme_credits");
        for (Map<String, Object> idMap : list) {
            int programmeId = Integer.parseInt((String) idMap.get("programme_id"));

            List<ProgrammeCredits> creditsList = jdbcTemplate.query("SELECT * FROM programme_credits WHERE programme_id = ?", resultSetExtractor, programmeId);
            ProgrammeCredits programmeCredits = mergeIntoSingleProgramCreditsWithListOfActors(programmeId, creditsList);

            results.add(programmeCredits);
        }

        return results;
    }

    private ProgrammeCredits mergeIntoSingleProgramCreditsWithListOfActors(int programmeId, List<ProgrammeCredits> creditsList) {
        //By using RowMapperResultSetExtractor we will get one ProgrammeCredits for each actor in a programme - we need to merge this into a single ProgrammeCredits
        ProgrammeCredits programmeCredits = new ProgrammeCredits();
        for (ProgrammeCredits credits : creditsList) {
            programmeCredits.setProgrammeId(programmeId);
            programmeCredits.getActors().addAll(credits.getActors());
        }
        return programmeCredits;

    }

    public ProgrammeCredits find(int id) {
        List<ProgrammeCredits> results = jdbcTemplate.query("SELECT * FROM programme_credits WHERE id = ?", rowMapper, id);
        return results.get(0);
    }

    public List<ProgrammeCredits> findByActor(int actorId) {
        List<ProgrammeCredits> results = new ArrayList<ProgrammeCredits>();

        List<Map<String, Object>> idMap = jdbcTemplate.queryForList("SELECT DISTINCT(programme_id) FROM programme_credits WHERE  actor_id = ?", resultSetExtractor, actorId);
        for (Map<String, Object> programmeIdMap : idMap) {
            int programmeId = Integer.parseInt((String) programmeIdMap.get("programme_id"));
            List<ProgrammeCredits> programmeCreditsList = jdbcTemplate.query("SELECT * FROM programme_credits WHERE programme_id = ?", resultSetExtractor, programmeId);
            ProgrammeCredits programmeCredits = mergeIntoSingleProgramCreditsWithListOfActors(programmeId, programmeCreditsList);
            results.add(programmeCredits);
        }

        return results;
    }

    public ProgrammeCredits findByProgramme(int programmeId) {
        List<ProgrammeCredits> creditsList = jdbcTemplate.query("SELECT * FROM programme_credits WHERE programme_id = ?", resultSetExtractor, programmeId);
        if (creditsList.size() > 1) {
            throw new RuntimeException("There should only be one credit list for one programme");
        }
        return creditsList.get(0);

    }

    public void save(ProgrammeCredits entity) {
        if (entity.getId() == 0) {
            for (Actor actor : entity.getActors()) {
                //TODO: Check that all actors are in the Actor table
                jdbcTemplate.update("INSERT INTO programme_credits (programme_id, actor_id) VALUES (?, ?)", entity.getProgrammeId(), actor.getId());
            }

        } else {
            for (Actor actor : entity.getActors()) {
                //TODO: Check that all actors are in the Actor table
                jdbcTemplate.update("UPDATE programme_credits SET programme_id = ?, actor_id = ?", entity.getProgrammeId(), actor.getId());
            }

        }
    }
}
