package org.joensson.nasdvr.model;

import javax.persistence.*;

/**
 * User: frj
 * Date: 3/22/12
 * Time: 8:55 AM
 *
 * @Author frj
 */
@Entity
@Table(name = "hdhr_channel_map")
public class ChannelMap {
//TODO Make this an enum and map it directly from the table using jpa2

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int entityId;

    @Column(name = "channel_map")
    private String channelMap;

    private String description;

    public String getChannelMap() {
        return channelMap;
    }

    public void setChannelMap(String channelMap) {
        this.channelMap = channelMap;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEntityId() {
        return entityId;
    }

    protected void setEntityId(int entityId) {
        this.entityId = entityId;
    }
}
