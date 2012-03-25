package org.joensson.nasdvr.dao.jdbc;

import org.joensson.nasdvr.dao.FrequencyRepository;
import org.joensson.nasdvr.model.Frequency;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FrequencyJdbcDao extends AbstractJdbcRepository<Frequency> implements FrequencyRepository {


    public List<Frequency> fetchAll() {
        List<Frequency> results = jdbcTemplate.query("SELECT * FROM hdhr_channel_frequency WHERE id = ?", rowMapper);
        return results;
    }

    public Frequency find(int id) {
        List<Frequency> results = jdbcTemplate.query("SELECT * FROM hdhr_channel_frequency WHERE id = ?", rowMapper, id);
        return results.get(0);
    }

    public List<Frequency> findByFrequency(int frequency) {
        List<Frequency> results = jdbcTemplate.query("SELECT * FROM hdhr_channel_frequency WHERE freq = ?", rowMapper, frequency);
        return results;
    }

    public List<Frequency> findBySymbolRate(int symbolRate) {
        List<Frequency> results = jdbcTemplate.query("SELECT * FROM hdhr_channel_frequency WHERE symbol_rate = ?", rowMapper, symbolRate);
        return results;
    }

    public void save(Frequency entity) {
        //TODO: Check if channelMapDao and modulationDao need to insert their objects
        if (entity.getId() == 0) {
            jdbcTemplate.update("INSERT INTO hdhr_channel_frequency (channel_map_id, modulation_id, freq, symbol_rate) VALUES (?, ?, ?, ?)", entity.getChannelMap().getId(), entity.getModulation().getId(), entity.getFrequency(), entity.getSymbolRate());
        } else {
            jdbcTemplate.update("UPDATE hdhr_channel_frequency SET channel_map_id = ?, modulation_id = ?, freq = ?, symbol_rate = ? WHERE id = ?", entity.getChannelMap().getId(), entity.getModulation().getId(), entity.getFrequency(), entity.getSymbolRate(), entity.getId());

        }
    }
}
