package com.example.Animal.Website.CRUD.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BirdController {

    @Autowired
    private BirdService birdService;

    @GetMapping
    public Object getAllBirds() {
        return birdService.getAllBirds();
    }

    @GetMapping("/{birdId}")
    public Bird getBirdById(@PathVariable Long birdId) {
        return birdService.getBirdById(birdId);
    }

    @GetMapping("/name/{name}")
    public Object getBirdByName(@PathVariable String name) {    
        return birdService.getBirdByName(name);
    }

    @GetMapping("/description/{description}")
    public Object getBirdByDescription(@PathVariable String description) {
        return birdService.getBirdByDescription(description);
    }

    @GetMapping("/breed/{breed}")
    public Object getBirdByBreed(@PathVariable String breed) {
        return birdService.getBirdByBreed(breed);
    }

    @GetMapping("/age/{age}")
    public Object getBirdByAge(@PathVariable int age) {
        return birdService.getBirdByAge(age);
    }

    @PostMapping("/birds")
    public Object addBird(@RequestBody Bird bird) {
        return birdService.addBird(bird);
    }

    @PutMapping("/{birdId}")
    public Bird updateBird(@PathVariable Long birdId, @RequestBody Bird bird) {
        return birdService.updateBird(birdId, bird);
    }

    @DeleteMapping("/{birdId}")
    public Object deleteBird(@PathVariable Long birdId) {
        birdService.deleteBird(birdId);
        return birdService.getAllBirds();
    }

    @PostMapping("/write")
    public Object writeJson(@RequestBody Bird bird) {
        birdService.writeJson(bird);
        return birdService.writeJson(bird);
    }

    @GetMapping("/birds/read")
    public Object readJson() {
        return birdService.readJson();
    }  
}
