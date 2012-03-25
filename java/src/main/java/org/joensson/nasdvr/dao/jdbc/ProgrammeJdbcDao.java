package org.joensson.nasdvr.dao.jdbc;

import org.joensson.nasdvr.dao.ProgrammeRepository;
import org.joensson.nasdvr.model.Programme;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ProgrammeJdbcDao extends AbstractJdbcRepository<Programme> implements ProgrammeRepository {

    public List<Programme> fetchAll() {
        List<Programme> programmes = jdbcTemplate.query("SELECT * FROM programme", rowMapper);
        return programmes;
    }

    public Programme find(int id) {
        List<Programme> programmes = jdbcTemplate.query("SELECT * FROM programme WHERE id = ?", rowMapper, id);
        return programmes.get(0);
    }

    public List<Programme> findByEpisodeNum(String epNum) {
        List<Programme> programmes = jdbcTemplate.query("SELECT * FROM programme WHERE episode_num = ?", rowMapper, epNum);

        return programmes;
    }

    public List<Programme> findByStartTime(Date startTime) {
        List<Programme> programmes = jdbcTemplate.query("SELECT * FROM programme WHERE start_time = ?", rowMapper, startTime);
        return programmes;
    }

    public List<Programme> findByTitle(String title) {
        List<Programme> programmes = jdbcTemplate.query("SELECT * FROM programme WHERE title = ?", rowMapper, title);
        return programmes;
    }

    public List<Programme> findBySubTitle(String subTitle) {
        List<Programme> programmes = jdbcTemplate.query("SELECT * FROM programme WHERE sub_title = ?", rowMapper, subTitle);
        return programmes;
    }

    public void save(Programme entity) {
        if (entity.getId() == 0) {
            jdbcTemplate.update("INSERT INTO programme (channel_id, start_time, end_time, title, sub_title, description, category_id, episode_num, icon) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                                entity.getChannel().getId(),
                                entity.getStartTime(),
                                entity.getEndTime(),
                                entity.getTitle(),
                                entity.getSubTitle(),
                                entity.getDescription(),
                                entity.getCategory().getId(),
                                entity.getEpisodeNumber(),
                                entity.getIcon()
            );
        } else {
            jdbcTemplate.update("UPDATE programme SET channel_id = ?, start_time = ?, end_time = ?, title = ?, sub_title = ?, description = ?, category_id = ?, episode_num = ?, icon = ? WHERE id = ?",
                                entity.getChannel().getId(),
                                entity.getStartTime(),
                                entity.getEndTime(),
                                entity.getTitle(),
                                entity.getSubTitle(),
                                entity.getDescription(),
                                entity.getCategory().getId(),
                                entity.getEpisodeNumber(),
                                entity.getIcon(),
                                entity.getId()
            );
        }
    }
}
