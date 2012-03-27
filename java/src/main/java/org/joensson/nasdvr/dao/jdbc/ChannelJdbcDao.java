package org.joensson.nasdvr.dao.jdbc;

import org.joensson.nasdvr.dao.ChannelRepository;
import org.joensson.nasdvr.dao.ProgramRepository;
import org.joensson.nasdvr.model.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChannelJdbcDao extends AbstractRowMappingJdbcRepository<Channel> implements ChannelRepository {


    @Autowired
    private ProgramRepository programRepository;

    public ChannelJdbcDao() {
        super();
        rowMapper.setCheckFullyPopulated(false); //to allow for us to retrieve hdhr_program_id and set that manually
    }


    public List<Channel> fetchAll() {
        List<Channel> results = jdbcTemplate.query("SELECT * FROM channel", rowMapper);
        return results;
    }

    public List<Channel> find(String displayName) {
        List<Channel> results = jdbcTemplate.query("SELECT * FROM channel WHERE display_name = ?", rowMapper, displayName);
        for (Channel result : results) {
            //TODO: Call programdao and insert Program
        }
        return results;
    }

    public Channel find(int id) {
        List<Channel> results = jdbcTemplate.query("SELECT * FROM channel WHERE id = ?", rowMapper, id);
        //TODO: Call programdao and insert Program
        return results.get(0);
    }

    public void save(Channel channel) {
        //TODO: Call programdao and create program before inserting reference
        if (channel.getId() == 0) {
            jdbcTemplate.update("INSERT INTO channel (channel_id, display_name, program_id) VALUES (?, ?, ?)", channel.getChannelId(), channel.getDisplayName(), channel.getProgramId());
        } else {
            jdbcTemplate.update("UPDATE channel SET channel_id = ?, display_name = ?, program_id = ? WHERE id = ?", channel.getChannelId(), channel.getDisplayName(), channel.getProgramId(), channel.getId());
        }
    }
}
