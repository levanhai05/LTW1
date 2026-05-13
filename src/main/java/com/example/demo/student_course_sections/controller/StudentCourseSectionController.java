package com.example.demo.student_course_sections.controller;

import com.example.demo.student_course_sections.model.entity.StudentCourseSection;
import com.example.demo.student_course_sections.service.StudentCourseSectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/student-course-sections")
@CrossOrigin
public class StudentCourseSectionController {

    private final StudentCourseSectionService service;

    public StudentCourseSectionController(StudentCourseSectionService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentCourseSection> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public StudentCourseSection getById(@PathVariable UUID id) { return service.getById(id); }

    @PostMapping
    public StudentCourseSection create(@RequestBody StudentCourseSection scs) { return service.create(scs); }

    @PutMapping("/{id}")
    public StudentCourseSection update(@PathVariable UUID id, @RequestBody StudentCourseSection scs) {
        return service.update(id, scs);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.delete(id); }

    @GetMapping("/by-student/{studentId}")
    public List<StudentCourseSection> getByStudent(@PathVariable UUID studentId) {
        return service.getByStudent(studentId);
    }

    @GetMapping("/by-course-section/{courseSectionId}")
    public List<StudentCourseSection> getByCourseSection(@PathVariable UUID courseSectionId) {
        return service.getByCourseSection(courseSectionId);
    }

    @GetMapping("/by-status")
    public List<StudentCourseSection> getByStatus(@RequestParam String status) {
        return service.getByStatus(status);
    }

    @GetMapping("/active")
    public List<StudentCourseSection> getActive() { return service.getActive(); }

    @GetMapping("/search")
    public List<StudentCourseSection> search(@RequestParam String name) { return service.search(name); }
}