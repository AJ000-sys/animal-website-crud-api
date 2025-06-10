package com.example.Animal.Website.CRUD.API;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BirdService {

    @Autowired
    private BirdRepository birdRepository;

    public Object getAllBirds() {
        return birdRepository.findAll();
    }

    public Bird getBirdById(@PathVariable Long birdId) {
        return birdRepository.findById(birdId).orElse(null);
    }

    public Object getBirdByName(String name) {
        if (name == null || name.isEmpty()) {
            return Collections.emptyList();
        }
        return birdRepository.getBirdByName(name);
    }

    public Object getBirdByDescription(String description) {
        if (description == null || description.isEmpty()) {
            return Collections.emptyList();
        }
        return birdRepository.getBirdByDescription(description);
    }

    public Object getBirdByHabitat(String Habitat) {
        if (Habitat == null || Habitat.isEmpty()) {
            return Collections.emptyList();
        }
        return birdRepository.getBirdByHabitat(Habitat);
    }

    public Object getBirdByLifeSpan(int lifeSpan) {
        return birdRepository.findAll().stream()
                .filter(b -> b.getLifeSpan() == lifeSpan)
                .toList();
    }

    public Bird addBird(Bird bird) {
        return birdRepository.save(bird);
    }

    public Bird updateBird(Long birdId, Bird bird) {
        return birdRepository.save(bird);
    }

    public void deleteBird(Long birdId) {
        birdRepository.deleteById(birdId);
    }

    public Object writeJson(Bird bird) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("birds.json"), bird);
            return "Bird written to JSON file successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error writing bird to JSON file";
        }
    }

    public Object readJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("birds.json"), Bird.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
