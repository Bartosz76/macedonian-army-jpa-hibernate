package bm.app.macedonianarmyjpahibernate.controller;

import bm.app.macedonianarmyjpahibernate.model.Macedonian;
import bm.app.macedonianarmyjpahibernate.repository.MacedonianRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MacedonianController {

    private MacedonianRepository macedonianRepository;

    public MacedonianController(MacedonianRepository macedonianRepository) {
        this.macedonianRepository = macedonianRepository;
    }

    @GetMapping("/getMacedonians")
    public List<Macedonian> getMacedonians() {
        return macedonianRepository.findAll();
    }

    @PostMapping("/addMacedonian")
    public void addMacedonian(@RequestBody Macedonian macedonian) {
        macedonianRepository.save(macedonian);
    }
}
