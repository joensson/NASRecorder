package org.joensson.nasdvr.model;

import javax.persistence.*;

@Entity
@Table(name = "hdhr_modulation")
public class Modulation  implements   NasDvrEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getModulation() {
        return modulation;
    }

    public void setModulation(String modulation) {
        this.modulation = modulation;
    }
}
