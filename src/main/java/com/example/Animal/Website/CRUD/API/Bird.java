package com.example.Animal.Website.CRUD.API;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "birds") 
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long birdId;
    
    private String name;
    private String description;
    private String breed;
    private int age;

    public Bird() {
    }

    public Bird(Long birdId, String name, String description, String breed, int age) {
        this.birdId = birdId;
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
    }

    public Bird(String name, String description, String breed, int age) {
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
    }

    public Long getBirdId() {
        return birdId;
    }

    public void setBirdId(Long birdId) {
        this.birdId = birdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
