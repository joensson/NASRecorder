package org.joensson.nasdvr.dao;

import org.joensson.nasdvr.model.Program;

import java.util.List;

public interface ProgramRepository extends NasDvrRepository<Program> {

    public List<Program> find(String programName);
    public Program findProgram(int programNumber);
}
