package org.joensson.nasdvr.model;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "actor")
public class Actor extends NasDvrEntity {

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

    @Column(name = "actor_name")
    private String actorName;

    @Column(name = "character_name")
    private String characterName;


    @OneToMany
    @JoinColumn(name = "actor_id")
    private List<ProgrammeCredits> credits;


    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getActorName() {
        return actorName;
    }

    public String getCharacterName() {
        return characterName;
    }


}
