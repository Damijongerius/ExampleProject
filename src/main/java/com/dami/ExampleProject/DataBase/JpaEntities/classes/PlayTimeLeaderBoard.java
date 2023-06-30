package com.dami.ExampleProject.DataBase.JpaEntities.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayTimeLeaderBoard {
    @JsonProperty("userName")
    String userName;
    @JsonProperty("saveName")
    String saveName;
    @JsonProperty("playtime")
    String playTime;

    public PlayTimeLeaderBoard(String userName, String saveName, String playTime) {
        this.userName = userName;
        this.saveName = saveName;
        this.playTime = playTime;
    }

    public String getPlaytime(){
        return playTime;
    }


}
