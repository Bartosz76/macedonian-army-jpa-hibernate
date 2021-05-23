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

    @GetMapping("/getSingleMacedonianByName")
    public List<Macedonian> getSingleMacedonianByName(@RequestParam String name) {
        return macedonianRepository.findByName(name);
    }

    @GetMapping("/getUnitById")
    public List<Macedonian> getMacedoniansByUnitOrderById(@RequestParam String unit) {
        return macedonianRepository.findByUnitOrderById(unit);
    }
}
