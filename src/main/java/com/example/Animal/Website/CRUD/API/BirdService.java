package com.example.Animal.Website.CRUD.API;

import java.io.File;
import java.io.IOException;
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
        return birdRepository.getBirdByName(name);
    }

    public Object getBirdByDescription(String description) {
        return birdRepository.getBirdByDescription(description);
    }

    public Object getBirdByBreed(String breed) {
        return birdRepository.getBirdByBreed(breed);
    }

    public Bird getBirdByAge(int age) {
        return birdRepository.findAll().stream()
                .filter(b -> b.getAge() == age)
                .findFirst()
                .orElse(null);
    }

      public Bird addBird(Bird bird) {
        return birdRepository.save(bird);
    }

    public Bird updateBird(Long birdId, Bird bird) {
        bird.setBirdId(birdId);
        return birdRepository.save(bird);
    }

    public void deleteBird(Long birdId) {
        birdRepository.deleteById(birdId);
    }

    public String writeJson(Bird bird) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("birds.json"), bird);
            return "Bird written to JSON file successfully";
        } catch (IOException e) {
            return "Error writing bird to JSON file";
        }
    }

    public Bird readJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("birds.json"), Bird.class);
        } catch (IOException e) {
            return null;
        }
    }

}