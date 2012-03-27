package org.joensson.nasdvr.model;

import javax.persistence.*;


@Entity
@Table(name = "hdhr_channel_map")
public class ChannelMap extends NasDvrEntity {
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


//TODO Make this an enum and map it directly from the table using jpa2

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

}
