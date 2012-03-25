package org.joensson.nasdvr.dao;

import org.joensson.nasdvr.model.Channel;

import java.util.List;

/**
 * User: frj
 * Date: 3/25/12
 * Time: 9:28 PM
 *
 * @Author frj
 */
public interface ChannelRepository extends NasDvrRepository<Channel> {

    public List<Channel> find(String displayName);

}
