package org.joensson.nasdvr.dao.jdbc;

import org.joensson.nasdvr.dao.ModulationRepository;
import org.joensson.nasdvr.model.Modulation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModulationJdbcDao extends AbstractRowMappingJdbcRepository<Modulation> implements ModulationRepository {

    public List<Modulation> fetchAll() {
        List<Modulation> results = jdbcTemplate.query("SELECT * FROM hdhr_modulation", rowMapper);
        return results;
    }

    public Modulation find(int id) {
        List<Modulation> results = jdbcTemplate.query("SELECT * FROM hdhr_modulation WHERE id = ?", rowMapper, id);
        return results.get(0);
    }

    public List<Modulation> find(String modulation) {
        List<Modulation> results = jdbcTemplate.query("SELECT * FROM hdhr_modulation WHERE modulation = ?", rowMapper, modulation);
        return results;
    }

    public void save(Modulation entity) {
        //TODO: Decide if we should throw an error. hdhr_modulation should be initialized by schema.sql
    }
}
