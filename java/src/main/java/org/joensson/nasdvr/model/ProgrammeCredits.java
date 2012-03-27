package org.joensson.nasdvr.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "programme_credits")
public class ProgrammeCredits extends NasDvrEntity {
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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "programme_id")
    private Programme programme;

    @OneToMany(mappedBy = "credits")
    private List<Actor> actors = new ArrayList<Actor>();

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    @Transient
    private int programmeId;

    public int getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(int programmeId) {
        this.programmeId = programmeId;
    }
}
