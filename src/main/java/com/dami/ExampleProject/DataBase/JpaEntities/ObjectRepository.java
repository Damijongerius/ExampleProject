package com.dami.ExampleProject.DataBase.JpaEntities;

import com.dami.ExampleProject.DataBase.JpaEntities.classes.Objects;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends JpaRepository<Objects, Integer> {
}