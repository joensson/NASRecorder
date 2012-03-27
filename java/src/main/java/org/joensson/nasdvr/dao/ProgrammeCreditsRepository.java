package org.joensson.nasdvr.dao;

import org.joensson.nasdvr.model.ProgrammeCredits;

import java.util.List;

public interface ProgrammeCreditsRepository extends NasDvrRepository<ProgrammeCredits> {

    public ProgrammeCredits findByProgramme(int programmeId);

    public List<ProgrammeCredits> findByActor(int actorId);
}
