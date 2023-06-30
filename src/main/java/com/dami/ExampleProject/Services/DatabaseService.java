package com.dami.ExampleProject.Services;

import com.dami.ExampleProject.DataBase.JpaEntities.*;
import com.dami.ExampleProject.DataBase.JpaEntities.classes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class DatabaseService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final MapRepository mapRepository;
    private final StatisticsRepository statisticsRepository;
    private final ObjectRepository objectRepository;

    private static DatabaseService instance;

    @Autowired
    public DatabaseService(UserRepository userRepository, ProfileRepository profileRepository, MapRepository mapRepository, StatisticsRepository statisticsRepository, ObjectRepository objectRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.mapRepository = mapRepository;
        this.statisticsRepository = statisticsRepository;
        this.objectRepository = objectRepository;

        instance = this;
    }

    public List<MoneyLeaderBoard> getUsersData() {
        List<User> users = userRepository.findAll();
        List<MoneyLeaderBoard> userLeaderboard = new ArrayList<>();

        for (User user : users) {
            Profile profile = profileRepository.findByUserId(user.getId());
            Statistics statistics = statisticsRepository.findByProfileId(profile.getId());

            if (statistics != null) {

                int money = statistics.getMoney();
                String username = user.getUserName();
                String saveName = profile.getSaveName();
                userLeaderboard.add(new MoneyLeaderBoard(username,saveName,(float)money));
            }
        }

        return  userLeaderboard;
    }

    public List<PlayTimeLeaderBoard> getPlayTimeUsers() {
        List<User> users = userRepository.findAll();
        List<PlayTimeLeaderBoard> userLeaderboard = new ArrayList<>();

        for (User user : users) {
            Profile profile = profileRepository.findByUserId(user.getId());
            Statistics statistics = statisticsRepository.findByProfileId(profile.getId());

            if (statistics != null) {

                String playTime = statistics.getTimePlayed();
                String username = user.getUserName();
                String saveName = profile.getSaveName();
                userLeaderboard.add(new PlayTimeLeaderBoard(username,saveName,playTime));
            }
        }


        return  userLeaderboard;

    }

    // Other methods for performing database operations
}