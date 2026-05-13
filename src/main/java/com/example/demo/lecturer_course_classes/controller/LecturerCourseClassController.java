package com.example.demo.lecturer_course_classes.controller;

import com.example.demo.lecturer_course_classes.model.entity.LecturerCourseClass;
import com.example.demo.lecturer_course_classes.service.LecturerCourseClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lecturer-course-classes")
@CrossOrigin
public class LecturerCourseClassController {

    private final LecturerCourseClassService service;

    public LecturerCourseClassController(LecturerCourseClassService service) {
        this.service = service;
    }

    @GetMapping
    public List<LecturerCourseClass> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public LecturerCourseClass getById(@PathVariable UUID id) { return service.getById(id); }

    @PostMapping
    public LecturerCourseClass create(@RequestBody LecturerCourseClass lcc) { return service.create(lcc); }

    @PutMapping("/{id}")
    public LecturerCourseClass update(@PathVariable UUID id, @RequestBody LecturerCourseClass lcc) {
        return service.update(id, lcc);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.delete(id); }

    @GetMapping("/by-employee/{employeeId}")
    public List<LecturerCourseClass> getByEmployee(@PathVariable UUID employeeId) {
        return service.getByEmployee(employeeId);
    }

    @GetMapping("/by-course-class/{courseClassId}")
    public List<LecturerCourseClass> getByCourseClass(@PathVariable UUID courseClassId) {
        return service.getByCourseClass(courseClassId);
    }

    @GetMapping("/by-role")
    public List<LecturerCourseClass> getByRole(@RequestParam String role) {
        return service.getByRole(role);
    }

    @GetMapping("/active")
    public List<LecturerCourseClass> getActive() { return service.getActive(); }
}
