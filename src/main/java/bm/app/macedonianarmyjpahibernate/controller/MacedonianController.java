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

    @GetMapping(value = "/getMacedonians", produces = {"application/json"})
    public List<Macedonian> getMacedonians() {
        return macedonianRepository.findAll();
    }

    @PostMapping("/addMacedonian/{macedonian}")
    public void addMacedonian(@RequestBody Macedonian macedonian) {
        macedonianRepository.save(macedonian);
    }

    @GetMapping("/getSingleMacedonianByName/{name}")
    public List<Macedonian> getSingleMacedonianByName(@RequestParam String name) {
        return macedonianRepository.findByName(name);
    }

    @GetMapping("/getUnitById/{unit}")
    public List<Macedonian> getMacedoniansByUnitOrderById(@RequestParam String unit) {
        return macedonianRepository.findByUnitOrderById(unit);
    }

    @GetMapping("/getMacedonianByQuery/{name}")
    public List<Macedonian> getMacedonianByNameWithQuery(@RequestParam String name) {
        return macedonianRepository.find(name);
    }

    @DeleteMapping("/dischargeMacedonian/{id}")
    public void dischargeMacedonian(@RequestParam Long id) {
        macedonianRepository.delete(macedonianRepository.getById(id));
    }
}
