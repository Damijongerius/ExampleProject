package com.dami.ExampleProject.DataBase.JpaEntities;

import com.dami.ExampleProject.DataBase.JpaEntities.classes.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findByUsersId(String id);
}
