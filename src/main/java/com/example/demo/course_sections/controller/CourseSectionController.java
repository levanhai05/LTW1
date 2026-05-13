package com.example.demo.course_sections.controller;

import com.example.demo.course_sections.model.entity.CourseSection;
import com.example.demo.course_sections.service.CourseSectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/course-sections")
@CrossOrigin
public class CourseSectionController {

    private final CourseSectionService service;

    public CourseSectionController(CourseSectionService service) {
        this.service = service;
    }

    @GetMapping
    public List<CourseSection> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public CourseSection getById(@PathVariable UUID id) { return service.getById(id); }

    @PostMapping
    public CourseSection create(@RequestBody CourseSection cs) { return service.create(cs); }

    @PutMapping("/{id}")
    public CourseSection update(@PathVariable UUID id, @RequestBody CourseSection cs) {
        return service.update(id, cs);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.delete(id); }

    @GetMapping("/search")
    public List<CourseSection> search(@RequestParam String name) { return service.search(name); }

    @GetMapping("/by-semester/{semesterId}")
    public List<CourseSection> getBySemester(@PathVariable UUID semesterId) {
        return service.getBySemester(semesterId);
    }

    @GetMapping("/by-course/{courseId}")
    public List<CourseSection> getByCourse(@PathVariable UUID courseId) {
        return service.getByCourse(courseId);
    }

    @GetMapping("/by-status")
    public List<CourseSection> getByStatus(@RequestParam String status) {
        return service.getByStatus(status);
    }

    @GetMapping("/active")
    public List<CourseSection> getActive() { return service.getActive(); }
}
