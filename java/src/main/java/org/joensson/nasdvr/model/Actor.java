package org.joensson.nasdvr.model;


import org.codehaus.jackson.annotate.JsonAutoDetect;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "actor")
public class Actor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int entityId;
    
    @Column(name = "actor_name")
    private String actorName;

    @Column(name = "character_name")
    private String characterName;


    @OneToMany
    @JoinColumn(name = "actor_id")
    private List<ProgrammeCredits> credits;

    protected void setEntityId(int entityId) {
        this.entityId = entityId;
    }

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

    public int getEntityId() {
        return entityId;
    }

}
