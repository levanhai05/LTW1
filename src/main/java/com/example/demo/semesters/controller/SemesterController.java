package com.example.demo.semesters.controller;

import com.example.demo.semesters.model.entity.Semester;
import com.example.demo.semesters.service.SemesterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/semesters")
@CrossOrigin
public class SemesterController {

    private final SemesterService service;

    public SemesterController(SemesterService service) {
        this.service = service;
    }

    @GetMapping
    public List<Semester> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Semester getById(@PathVariable UUID id) { return service.getById(id); }

    @PostMapping
    public Semester create(@RequestBody Semester semester) { return service.create(semester); }

    @PutMapping("/{id}")
    public Semester update(@PathVariable UUID id, @RequestBody Semester semester) {
        return service.update(id, semester);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.delete(id); }

    @GetMapping("/search")
    public List<Semester> search(@RequestParam String name) { return service.search(name); }

    @GetMapping("/by-school-year/{schoolYearId}")
    public List<Semester> getBySchoolYear(@PathVariable UUID schoolYearId) {
        return service.getBySchoolYear(schoolYearId);
    }

    @GetMapping("/active")
    public List<Semester> getActive() { return service.getActive(); }
}
