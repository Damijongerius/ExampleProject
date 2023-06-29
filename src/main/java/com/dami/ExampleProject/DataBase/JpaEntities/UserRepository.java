package com.dami.ExampleProject.DataBase.JpaEntities;

import com.dami.ExampleProject.DataBase.JpaEntities.classes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
