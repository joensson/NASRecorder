package org.joensson.nasdvr.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractJdbcRepository {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

}
