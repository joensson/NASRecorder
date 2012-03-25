package org.joensson.nasdvr.dao;

import org.joensson.nasdvr.model.NasDvrEntity;

import java.util.List;

public interface NasDvrRepository<T extends NasDvrEntity> {

    public List<T> fetchAll();

    public T find(int id);

    public void save(T entity );
}
