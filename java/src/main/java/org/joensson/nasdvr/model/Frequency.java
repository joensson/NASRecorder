package org.joensson.nasdvr.model;

import javax.persistence.*;

@Entity
@Table(name = "hdhr_channel_frequency")
public class Frequency extends NasDvrEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    @Column(name = "frequency")
    private int frequency;

    @Column(name = "symbol_rate")
    private int symbolRate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "channel_map_id")
    private ChannelMap channelMap;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "modulation_id")
    private Modulation modulation;

    public ChannelMap getChannelMap() {
        return channelMap;
    }

    public void setChannelMap(ChannelMap channelMap) {
        this.channelMap = channelMap;
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


    //This field is used by the jdbc row mapper - rather than setting the ChannelMap object, the foreign key is set
    @Transient
    private int channelMapId;

    public int getChannelMapId() {
        return channelMapId;
    }

    public void setChannelMapId(int channelMapId) {
        this.channelMapId = channelMapId;
    }

    //This field is used by the jdbc row mapper - rather than setting the Modulation object, the foreign key is set
    @Transient
    private int modulationId;

    public int getModulationId() {
        return modulationId;
    }

    public void setModulationId(int modulationId) {
        this.modulationId = modulationId;
    }
}
