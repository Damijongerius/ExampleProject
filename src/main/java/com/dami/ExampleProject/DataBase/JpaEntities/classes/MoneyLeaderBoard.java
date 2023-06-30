package com.dami.ExampleProject.DataBase.JpaEntities.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
public class MoneyLeaderBoard {
    @JsonProperty("userName")
    String userName;
    @JsonProperty("saveName")
    String saveName;
    @JsonProperty("money")
    Float money;

    public MoneyLeaderBoard(String userName, String saveName, Float money){
        this.money =  money;
        this.userName =userName;
        this.saveName =  saveName;
    }

    public Float getMoney(){
        return this.money;
    }
}
