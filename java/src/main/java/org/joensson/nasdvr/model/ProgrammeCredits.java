package org.joensson.nasdvr.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "programme_credits")
public class ProgrammeCredits  implements   NasDvrEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "programme_id")
    private Programme programme;

    @OneToMany(mappedBy = "credits")
    private List<Actor> actors;

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

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

}
