package org.joensson.nasdvr.model;

import javax.persistence.*;

/**
 * User: frj
 * Date: 3/22/12
 * Time: 8:30 AM
 *
 * @Author frj
 */
@Entity
@Table(name = "hdhr_channel_frequency")
public class Frequency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int entityId;

    @Column(name = "freq")
    private int frequency;

    @Column(name = "symbol_rate")
    private int symbolRate;

    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "channel_map_id")
    private ChannelMap channelMap;

    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "modulation_id")
    private Modulation modulation;


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

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Modulation getModulation() {
        return modulation;
    }

    public void setModulation(Modulation modulation) {
        this.modulation = modulation;
    }

    public int getSymbolRate() {
        return symbolRate;
    }

    public void setSymbolRate(int symbolRate) {
        this.symbolRate = symbolRate;
    }
}
