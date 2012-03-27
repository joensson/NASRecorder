package org.joensson.nasdvr.model;

import javax.persistence.*;

@Entity
@Table(name = "channel")
public class Channel extends NasDvrEntity {
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

    @Column(name = "channel_id")
    private String channelId;

    @Column(name = "display_name")
    private String displayName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "program_id")
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

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    //This field is used by JdbcRowMapper rather than setting the actual Program, only the foreign key is set
    @Transient
    private int programId;

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

}
