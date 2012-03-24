package org.joensson.nasdvr.model;

import javax.persistence.*;

/**
 * User: frj
 * Date: 3/22/12
 * Time: 8:58 AM
 *
 * @Author frj
 */
@Entity
@Table(name = "hdhr_modulation")
public class Modulation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int entityId;

    private String modulation;

    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "channel_map_id")
    private ChannelMap channelMap;


    public ChannelMap getChannelMap() {
        return channelMap;
    }

    public void setChannelMap(ChannelMap channelMap) {
        this.channelMap = channelMap;
    }

    public int getEntityId() {
        return entityId;
    }

    protected void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public String getModulation() {
        return modulation;
    }

    public void setModulation(String modulation) {
        this.modulation = modulation;
    }
}
