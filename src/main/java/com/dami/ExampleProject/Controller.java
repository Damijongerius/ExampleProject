package com.dami.ExampleProject;

import com.dami.ExampleProject.DataBase.JpaEntities.classes.MoneyLeaderBoard;
import com.dami.ExampleProject.DataBase.JpaEntities.classes.PlayTimeLeaderBoard;
import com.dami.ExampleProject.DataBase.JpaEntities.classes.User;
import com.dami.ExampleProject.Services.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Controller {
    private final DatabaseService service;

    @Autowired
    public Controller(DatabaseService databaseService) {
        this.service = databaseService;
    }

    @GetMapping("/Leaderboard/Money")
    public List<MoneyLeaderBoard> getMoneyLeaderBoard(){
        List<MoneyLeaderBoard> leaderboard =  service.getUsersData();
        leaderboard.sort(Comparator.comparingDouble(MoneyLeaderBoard::getMoney).reversed());

        return  leaderboard;
    }

    @GetMapping("/Leaderboard/Playtime")
    public List<PlayTimeLeaderBoard> getPlayTimeUsers(){
        System.out.println("post");
        List<PlayTimeLeaderBoard> leaderboardData = service.getPlayTimeUsers();
                sortPlaytimeLeaderboard(leaderboardData);
        return leaderboardData;
    }

    private void sortPlaytimeLeaderboard(List<PlayTimeLeaderBoard> leaderboardData) {
        leaderboardData.sort(Comparator.comparing(this::convertToMinutes).reversed());
    }

    // Method to convert playtime string into minutes
    private int convertToMinutes(PlayTimeLeaderBoard entry) {
        String playtime = entry.getPlaytime();
        String[] parts = playtime.split("h ");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1].replace("m", ""));
        return hours * 60 + minutes;
    }

    @GetMapping("/test/getSpecial/{resource}")
    public String getSpecialString(@PathVariable String resource){
        return "string :" + resource;
    }

}

