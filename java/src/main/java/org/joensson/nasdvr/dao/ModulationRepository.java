package org.joensson.nasdvr.dao;

import org.joensson.nasdvr.model.Modulation;

import java.util.List;

public interface ModulationRepository  extends NasDvrRepository<Modulation> {

    public List<Modulation> find(String modulation);
}
