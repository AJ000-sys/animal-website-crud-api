package com.example.Animal.Website.CRUD.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BirdController {

    @Autowired
    private BirdService birdService;

    @GetMapping("/birds")
    public Object getAllBirds() {
        return birdService.getAllBirds();
    }

    @GetMapping("/birds/{birdId}")
    public Bird getBirdById(@PathVariable Long birdId) {
        return birdService.getBirdById(birdId);
    }

    @GetMapping("/birds/name/{name}")
    public Object getBirdByName(@RequestParam String key) {
        if(key != null){
            return birdService.getBirdByName(key);
        }else{
            return birdService.getAllBirds();
        }
    }

    @GetMapping("/birds/description/{description}")
    public Object getBirdByDescription(@PathVariable String description) {
        return birdService.getBirdByDescription(description);
    }

    @GetMapping("/birds/breed/{breed}")
    public Bird getBirdByBreed(@PathVariable String breed) {
        return birdService.getBirdByBreed(breed);
    }

    @GetMapping("/birds/age/{age}")
    public Bird getBirdByAge(@PathVariable double age) {
        return birdService.getBirdByAge(age);
    }

    @PostMapping("/birds")
    public Bird addBird(@RequestBody Bird bird) {
        return birdService.addBird(bird);
    }

    @PutMapping("/birds/{birdId}")
    public Bird updateBird(@PathVariable Long birdId, @RequestBody Bird bird) {
        birdService.updateBird(birdId, bird);
        return birdService.getBirdById(birdId);
    }

    @DeleteMapping("/birds/{birdId}")
    public Object deleteBird(@PathVariable Long birdId) {
        birdService.deleteBird(birdId);
        return birdService.getAllBirds();
    }

    @PostMapping("/birds/write")
    public Object writeJson(@RequestBody Bird bird) {
        birdService.writeJson(bird);
        return birdService.writeJson(bird);
    }

    @GetMapping("/birds/read")
    public Object readJson() {
        return birdService.readJson();
    }  
}
