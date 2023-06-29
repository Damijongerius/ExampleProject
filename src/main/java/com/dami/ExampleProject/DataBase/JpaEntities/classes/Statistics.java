package com.dami.ExampleProject.DataBase.JpaEntities.classes;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profileId;

    @Column(name = "DateMade")
    private LocalDateTime dateMade;

    @Column(name = "DateSeen")
    private LocalDateTime dateSeen;

    @Column(name = "TimePlayed")
    private String timePlayed;

    @Column(name = "Money")
    private Integer money;

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

    public LocalDateTime getDateMade() {
        return dateMade;
    }

    public void setDateMade(LocalDateTime dateMade) {
        this.dateMade = dateMade;
    }

    public LocalDateTime getDateSeen() {
        return dateSeen;
    }

    public void setDateSeen(LocalDateTime dateSeen) {
        this.dateSeen = dateSeen;
    }

    public String getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(String timePlayed) {
        this.timePlayed = timePlayed;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
