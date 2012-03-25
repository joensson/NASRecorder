package org.joensson.nasdvr.dao.jdbc;

import org.joensson.nasdvr.model.NasDvrEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public  abstract class AbstractJdbcRepository<T extends NasDvrEntity>  {

    @Autowired
    protected JdbcTemplate jdbcTemplate;
    protected ParameterizedBeanPropertyRowMapper<T> rowMapper;

    protected AbstractJdbcRepository() {
        Class entityClazz = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);

        rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(entityClazz);
    }



}
