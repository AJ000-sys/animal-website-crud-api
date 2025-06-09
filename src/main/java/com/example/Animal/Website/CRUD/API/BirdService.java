package com.example.Animal.Website.CRUD.API;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BirdService {

    @Autowired
    private BirdRepository birdRepository;

    private static final String UPLOAD_DIR = "src/main/resources/static/bird-images/";

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

    public Bird addBird(Bird bird, MultipartFile image) {
        Bird newBird = birdRepository.save(bird);

        if (image != null && !image.isEmpty()) {
            String originalFileName = image.getOriginalFilename();
            try {
                if (originalFileName != null && originalFileName.contains(".")) {
                    String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                    String fileName = newBird.getBirdId() + fileExtension;
                    java.nio.file.Path filePath = Paths.get(UPLOAD_DIR + fileName);

                    InputStream inputStream = image.getInputStream();
                    Files.createDirectories(Paths.get(UPLOAD_DIR));
                    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                    newBird.setImagePath("bird-images/" + fileName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return birdRepository.save(newBird);
    }

    public Bird updateBird(Long birdId, Bird bird, MultipartFile image) {
        if (image != null && !image.isEmpty()) {
            String originalFileName = image.getOriginalFilename();
            try {
                if (originalFileName != null && originalFileName.contains(".")) {
                    String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                    String fileName = birdId + fileExtension;
                    java.nio.file.Path filePath = Paths.get(UPLOAD_DIR + fileName);

                    Files.deleteIfExists(filePath);

                    InputStream inputStream = image.getInputStream();
                    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                    bird.setImagePath("bird-images/" + fileName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return birdRepository.save(bird);
    }

    public void deleteBird(Long birdId) {
        Bird bird = birdRepository.findById(birdId).orElse(null);
        if (bird != null && bird.getImagePath() != null) {
            try {
                String fileName = bird.getImagePath().substring(bird.getImagePath().lastIndexOf("/") + 1);
                Files.deleteIfExists(Paths.get(UPLOAD_DIR + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        birdRepository.deleteById(birdId);
    }

    public Object writeJson(Bird bird) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("birds.json"), bird);
            return bird;
        } catch (IOException e) {
            return null;
        }
    }

    public Object readJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("birds.json"), Bird.class);
        } catch (IOException e) {
            return null;
        }
    }
}
