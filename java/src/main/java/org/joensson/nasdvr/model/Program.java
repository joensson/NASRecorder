package org.joensson.nasdvr.model;

import javax.persistence.*;


@Entity
@Table(name = "hdhr_program")
public class Program  implements   NasDvrEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int program;

    @Column(name = "program_name")
    private String programName;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "frequency_id")
    private Frequency frequency;

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
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
