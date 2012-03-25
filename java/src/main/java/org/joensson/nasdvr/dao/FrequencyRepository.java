package org.joensson.nasdvr.dao;

import org.joensson.nasdvr.model.Frequency;

import java.util.List;

/**
 * User: frj
 * Date: 3/25/12
 * Time: 10:23 PM
 *
 * @Author frj
 */
public interface FrequencyRepository extends NasDvrRepository<Frequency> {

    public List<Frequency> findBySymbolRate(int symbolRate);
    public List<Frequency> findByFrequency(int frequency);

}
