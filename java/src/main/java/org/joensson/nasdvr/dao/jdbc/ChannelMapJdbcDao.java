package org.joensson.nasdvr.dao.jdbc;

import org.joensson.nasdvr.dao.ChannelMapRepository;
import org.joensson.nasdvr.model.ChannelMap;

import java.util.List;

/**
 * User: frj
 * Date: 3/25/12
 * Time: 9:58 PM
 *
 * @Author frj
 */
public class ChannelMapJdbcDao extends AbstractJdbcRepository<ChannelMap> implements ChannelMapRepository {

    public ChannelMap find(int id) {
        List<ChannelMap> res = jdbcTemplate.query("SELECT * FROM hdhr_channel_map WHERE id = ?", rowMapper, id);
        return res.get(0);
    }

    public List<ChannelMap> find(String channelMapName) {
        List<ChannelMap> res = jdbcTemplate.query("SELECT * FROM hdhr_channel_map WHERE channel_map = ?", rowMapper, channelMapName);
        return res;
    }

    public void save(ChannelMap entity) {
        //TODO: ChannelMap is initialized by the database schema.sql
    }
}
