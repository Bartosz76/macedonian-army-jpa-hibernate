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

    /**
     * Specifying the format of the data is redundant if it's JSON since it's
     * the default type. I should specify it if I wanted a different one, like xml.
     * It would then be: "application/xml".
     */
    @GetMapping(value = "/getMacedonians", produces = {"application/json"})
    public List<Macedonian> getMacedonians() {
        return macedonianRepository.findAll();
    }

    @PostMapping(value = "/addMacedonian", consumes = {"application/json"})
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

    @GetMapping("/getMacedonianByQuery")
    public List<Macedonian> getMacedonianByNameWithQuery(@RequestParam String name) {
        return macedonianRepository.find(name);
    }

    @DeleteMapping("/dischargeMacedonian")
    public void dischargeMacedonian(@RequestParam Long id) {
        macedonianRepository.delete(macedonianRepository.getById(id));
    }
}
