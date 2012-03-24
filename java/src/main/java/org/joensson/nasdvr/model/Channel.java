package org.joensson.nasdvr.model;

import com.sun.javadoc.ProgramElementDoc;

import javax.persistence.*;

/**
 * User: frj
 * Date: 3/22/12
 * Time: 8:21 AM
 *
 * @Author frj
 */
@Entity
@Table(name = "channel")
public class Channel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int entityId;

    @Column(name = "channel_id")
    private String channelId;

    @Column(name = "display_name")
    private String displayName;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "hdhr_program_id")
    private Program program;


    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getEntityId() {
        return entityId;
    }

    protected void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
