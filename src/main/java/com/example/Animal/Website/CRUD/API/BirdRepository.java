package com.example.Animal.Website.CRUD.API;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {

    List<Bird> getBirdByName(String name);
    
}
