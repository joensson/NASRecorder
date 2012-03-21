package org.joensson.nasdvr.model;


import org.codehaus.jackson.annotate.JsonAutoDetect;

import javax.persistence.*;


@Entity
@Table(name = "actor")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Actor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int entityId;
    
    @Column(name = "actor_name")
    private String actorName;

    @Column(name = "character_name")
    private String characterName;


    public void setEntityId(int entityId) {
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
