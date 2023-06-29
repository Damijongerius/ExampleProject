package com.dami.ExampleProject.Services;

import com.dami.ExampleProject.DataBase.JpaEntities.*;
import com.dami.ExampleProject.DataBase.JpaEntities.classes.Profile;
import com.dami.ExampleProject.DataBase.JpaEntities.classes.Statistics;
import com.dami.ExampleProject.DataBase.JpaEntities.classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void insertData() {
        // Create and save entities
        User user = new User();
        user.setId("1");
        user.setUserName("john");
        user.setPassword("password");
        userRepository.save(user);

        // Insert data into other tables/entities as needed
    }

    public void getUsersData() {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            Profile profile = profileRepository.findByUsersId(user.getId());
            Statistics statistics = statisticsRepository.findByProfileId(profile.getId());

            if (statistics != null) {
                int money = statistics.getMoney();
                String username = user.getUserName();
                String saveName = profile.getSaveName();

                System.out.println("Username: " + username);
                System.out.println("Save Name: " + saveName);
                System.out.println("Money: $" + money);
                System.out.println("--------------------");
            }
        }
    }

    public static DatabaseService getInstance(){
        return instance;
    }

    // Other methods for performing database operations
}