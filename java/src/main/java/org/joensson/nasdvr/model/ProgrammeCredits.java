package org.joensson.nasdvr.model;

import javax.persistence.*;
import java.util.List;

/**
 * User: frj
 * Date: 3/22/12
 * Time: 9:08 AM
 *
 * @Author frj
 */
@Entity
@Table(name = "programme_credits")
public class ProgrammeCredits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int entityId;


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

    public int getEntityId() {
        return entityId;
    }

    protected void setEntityId(int entityId) {
        this.entityId = entityId;
    }

}
