package org.joensson.nasdvr.model;

import javax.persistence.*;

@Entity
@Table(name = "hdhr_modulation")
public class Modulation extends NasDvrEntity {
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


    private String modulation;

    public String getModulation() {
        return modulation;
    }

    public void setModulation(String modulation) {
        this.modulation = modulation;
    }

}
