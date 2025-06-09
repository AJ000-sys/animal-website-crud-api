package com.example.Animal.Website.CRUD.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/birds")
public class BirdController {

    @Autowired
    private BirdService birdService;

    @GetMapping
    public Object getAllBirds(Model model) {
        model.addAttribute("birdslist", birdService.getAllBirds());
        return "bird-list";
    }

    @GetMapping("/{birdId}")
    public Object getBirdById(@PathVariable Long birdId, Model model) {
        model.addAttribute("bird", birdService.getBirdById(birdId));
        model.addAttribute("Title", "Bird #" + birdId);
        return "bird-details";
    }

    @GetMapping("/new")
    public Object showCreateForm(Model model) {
        Bird bird = new Bird();
        model.addAttribute("bird", bird);
        model.addAttribute("Title", "Create New Bird");
        return "bird-create";
    }

    @GetMapping("/edit/{birdId}")
    public Object showUpdateForm(@PathVariable Long birdId, Model model) {
        model.addAttribute("bird", birdService.getBirdById(birdId));
        return "bird-update";
    }

    @PostMapping("/new")
    public Object createBird(@ModelAttribute Bird bird,
            @RequestParam("image") MultipartFile file,
            Model model) {
        try {
            Bird newBird = birdService.addBird(bird, file);
            return "redirect:/birds";
        } catch (Exception e) {
            model.addAttribute("error", "Failed to upload image");
            return "bird-create";
        }
    }

    @PostMapping("/update")
    public Object updateBird(@ModelAttribute Bird bird,
            @RequestParam("image") MultipartFile file) {
        birdService.updateBird(bird.getBirdId(), bird, file);
        return "redirect:/birds/" + bird.getBirdId();
    }

    @GetMapping("/delete/{birdId}")
    public Object deleteBird(@PathVariable Long birdId) {
        birdService.deleteBird(birdId);
        return "redirect:/birds";
    }

    @PostMapping("/writeFile")
    public Object writeJson(@RequestBody Bird bird) {
        birdService.writeJson(bird);
        return birdService.writeJson(bird);
    }

    @GetMapping("/readFile")
    public Object readJson() {
        return birdService.readJson();
    }
}
