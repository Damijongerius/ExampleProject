package com.dami.ExampleProject.DataBase.JpaEntities.classes;

import jakarta.persistence.*;

@Entity
@Table(name = "objects")
public class Objects {

    @EmbeddedId
    private ObjectsId id;

    @Column(name = "objectOrder")
    private String objectOrder;

    @ManyToOne
    @MapsId("profileId")
    @JoinColumn(name = "profile_id")
    private Map map;

    // Getters and setters
    public ObjectsId getId() {
        return id;
    }

    public void setId(ObjectsId id) {
        this.id = id;
    }

    public String getObjectOrder() {
        return objectOrder;
    }

    public void setObjectOrder(String objectOrder) {
        this.objectOrder = objectOrder;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

}