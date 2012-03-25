package org.joensson.nasdvr.dao;

import org.joensson.nasdvr.model.NasDvrEntity;

public interface NasDvrRepository<T extends NasDvrEntity> {

    public T find(int id);

    public void save(T entity );
}
