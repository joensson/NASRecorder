package org.joensson.nasdvr.model;

import javax.persistence.*;

@Entity
@Table(name = "channel")
public class Channel  implements   NasDvrEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
