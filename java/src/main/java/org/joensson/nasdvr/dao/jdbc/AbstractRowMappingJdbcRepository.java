package org.joensson.nasdvr.dao.jdbc;

import org.joensson.nasdvr.model.NasDvrEntity;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractRowMappingJdbcRepository<T extends NasDvrEntity> extends AbstractJdbcRepository {

    protected ParameterizedBeanPropertyRowMapper<T> rowMapper;

    protected AbstractRowMappingJdbcRepository() {
        Class entityClazz = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);

        rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(entityClazz);
    }


}
