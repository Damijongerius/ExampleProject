package com.dami.ExampleProject.DataBase.JpaEntities.classes;

import jakarta.persistence.*;

@Entity
@Table(name = "map")
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profileId;

    private float xRange;

    private float yRange;

    @OneToOne
    @MapsId
    @JoinColumn(name = "profile_id")
    private Profile profile;

    // Getters and setters
    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public float getXRange() {
        return xRange;
    }

    public void setXRange(float xRange) {
        this.xRange = xRange;
    }

    public float getYRange() {
        return yRange;
    }

    public void setYRange(float yRange) {
        this.yRange = yRange;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}