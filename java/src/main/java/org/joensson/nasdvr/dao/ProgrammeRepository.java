package org.joensson.nasdvr.dao;

import org.joensson.nasdvr.model.Programme;

import java.util.Date;
import java.util.List;

public interface ProgrammeRepository extends NasDvrRepository<Programme> {

    public List<Programme> findByStartTime(Date startTime);
    public List<Programme> findByTitle(String title);
    public List<Programme> findBySubTitle(String subTitle);
    public List<Programme> findByEpisodeNum(String epNum);


}
