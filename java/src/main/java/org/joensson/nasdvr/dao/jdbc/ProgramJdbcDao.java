package org.joensson.nasdvr.dao.jdbc;

import org.joensson.nasdvr.dao.ProgramRepository;
import org.joensson.nasdvr.model.Program;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProgramJdbcDao extends AbstractJdbcRepository<Program> implements ProgramRepository {

    //TODO Insert calls to FrequencyRepository
    public List<Program> fetchAll() {
        List<Program> programs = jdbcTemplate.query("SELECT * FROM hdhr_program", rowMapper);
        return programs;
    }

    public Program find(int id) {
        List<Program> programs = jdbcTemplate.query("SELECT * FROM hdhr_program WHERE id = ?", rowMapper, id);
        return programs.get(0);
    }

    public List<Program> find(String programName) {
        List<Program> programs = jdbcTemplate.query("SELECT * FROM hdhr_program WHERE program_name = ?", rowMapper, programName);
        return programs;
    }

    public Program findProgram(int programNumber) {
        List<Program> programs = jdbcTemplate.query("SELECT * FROM hdhr_program WHERE program = ?", rowMapper, programNumber);
        return programs.get(0);
    }

    public void save(Program entity) {
        if (entity.getId() == 0) {
            jdbcTemplate.update("INSERT INTO hdhr_program (frequency_id, program, program_name) VALUES (?, ?, ?)", entity.getFrequency().getId(), entity.getProgram(), entity.getProgramName());
        } else {
            jdbcTemplate.update("UPDATE hdhr_program SET frequency_id = ?, program = ?, program_name = ?", entity.getFrequency().getId(), entity.getProgram(), entity.getProgramName(), entity.getId());
        }
    }
}
