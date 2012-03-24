package org.joensson.nasdvr.model;

import javax.persistence.*;

/**
 * User: frj
 * Date: 3/22/12
 * Time: 8:18 AM
 *
 * @Author frj
 */
@Entity
@Table(name = "category")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int entityId;

    private String name;


    public int getEntityId() {
        return entityId;
    }

    protected void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
