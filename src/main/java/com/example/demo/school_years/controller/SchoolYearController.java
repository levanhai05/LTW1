package com.example.demo.school_years.controller;

import com.example.demo.school_years.model.entity.SchoolYear;
import com.example.demo.school_years.service.SchoolYearService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/school-years")
@CrossOrigin
public class SchoolYearController {

    private final SchoolYearService service;

    public SchoolYearController(SchoolYearService service) {
        this.service = service;
    }

    @GetMapping
    public List<SchoolYear> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public SchoolYear getById(@PathVariable UUID id) { return service.getById(id); }

    @PostMapping
    public SchoolYear create(@RequestBody SchoolYear schoolYear) { return service.create(schoolYear); }

    @PutMapping("/{id}")
    public SchoolYear update(@PathVariable UUID id, @RequestBody SchoolYear schoolYear) {
        return service.update(id, schoolYear);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.delete(id); }

    @GetMapping("/search")
    public List<SchoolYear> search(@RequestParam String name) { return service.search(name); }

    @GetMapping("/active")
    public List<SchoolYear> getActive() { return service.getActive(); }
}
