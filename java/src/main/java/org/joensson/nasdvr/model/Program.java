package org.joensson.nasdvr.model;

import javax.persistence.*;

/**
 * User: frj
 * Date: 3/22/12
 * Time: 8:27 AM
 *
 * @Author frj
 */

@Entity
@Table(name = "hdhr_program")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int entityId;

    private int program;

    @Column(name = "program_name")
    private String programName;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "frequency_id")
    private Frequency frequency;

    public int getEntityId() {
        return entityId;
    }

    protected void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public int getProgram() {
        return program;
    }

    public void setProgram(int program) {
        this.program = program;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
}
