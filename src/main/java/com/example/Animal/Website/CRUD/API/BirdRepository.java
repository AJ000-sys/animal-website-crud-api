package com.example.Animal.Website.CRUD.API;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {

    List<Bird> getBirdByHabitat(String habitat);

    @Query(value = "select * from birds b where b.name like %?1%", nativeQuery = true)
    List<Bird> getBirdByName(String name);

    @Query(value = "select * from birds b where b.description like %?1%", nativeQuery = true)
    List<Bird> getBirdByDescription(String description);
    
    @Query(value = "select * from birds b where b.life_span = ?1", nativeQuery = true)
    List<Bird> getBirdByLifeSpan(int lifeSpan);
}
