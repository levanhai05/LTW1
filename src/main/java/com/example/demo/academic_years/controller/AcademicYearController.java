package com.example.demo.academic_years.controller;

import com.example.demo.academic_years.model.entity.AcademicYear;
import com.example.demo.academic_years.service.AcademicYearService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/academic-years")
@CrossOrigin
public class AcademicYearController {

    private final AcademicYearService service;

    public AcademicYearController(AcademicYearService service) {
        this.service = service;
    }

    @GetMapping
    public List<AcademicYear> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AcademicYear getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public AcademicYear create(@RequestBody AcademicYear academicYear) {
        return service.create(academicYear);
    }

    @PutMapping("/{id}")
    public AcademicYear update(@PathVariable UUID id, @RequestBody AcademicYear academicYear) {
        return service.update(id, academicYear);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @GetMapping("/search")
    public List<AcademicYear> search(@RequestParam String name) {
        return service.search(name);
    }

    @GetMapping("/active")
    public List<AcademicYear> getActive() {
        return service.getActive();
    }
}
