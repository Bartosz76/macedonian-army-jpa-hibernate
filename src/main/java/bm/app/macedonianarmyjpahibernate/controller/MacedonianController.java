package bm.app.macedonianarmyjpahibernate.controller;

import bm.app.macedonianarmyjpahibernate.model.Macedonian;
import bm.app.macedonianarmyjpahibernate.repository.MacedonianRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
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
