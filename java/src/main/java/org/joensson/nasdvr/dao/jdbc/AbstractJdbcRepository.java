package org.joensson.nasdvr.dao.jdbc;

import org.joensson.nasdvr.model.NasDvrEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

/**
 * User: frj
 * Date: 3/25/12
 * Time: 10:08 PM
 *
 * @Author frj
 */
public  abstract class AbstractJdbcRepository<T extends NasDvrEntity>  {

    private Class<T> entityClazz;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    protected ParameterizedBeanPropertyRowMapper<T> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(entityClazz);

}
