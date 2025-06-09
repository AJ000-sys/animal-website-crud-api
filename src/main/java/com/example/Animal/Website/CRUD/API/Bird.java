package com.example.Animal.Website.CRUD.API;

import jakarta.persistence.Column;
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
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(name = "life_span", nullable = false)
    private int lifeSpan;
    
    @Column(nullable = false)
    private String habitat;

    @Column(name = "image_path")
    private String imagePath;

    public Bird() {
    }

    public Bird(Long birdId, String name, String description, int lifeSpan, String habitat, String imagePath) {
        this.birdId = birdId;
        this.name = name;
        this.description = description;
        this.lifeSpan = lifeSpan;
        this.habitat = habitat;
        this.imagePath = imagePath;
    }

    public Bird(String name, String description, int lifeSpan, String habitat, String imagePath) {
        this.name = name;
        this.description = description;
        this.lifeSpan = lifeSpan;
        this.habitat = habitat;
        this.imagePath = imagePath;
    }

    public Long getBirdId() {
        return birdId;
    }

    public void setBirdId(Long id) {
        this.birdId = id;
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

    public int getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
