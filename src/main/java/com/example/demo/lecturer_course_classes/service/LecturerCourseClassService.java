package com.example.demo.lecturer_course_classes.service;

import com.example.demo.lecturer_course_classes.model.entity.LecturerCourseClass;
import com.example.demo.lecturer_course_classes.repository.LecturerCourseClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LecturerCourseClassService {

    private final LecturerCourseClassRepository repo;

    public LecturerCourseClassService(LecturerCourseClassRepository repo) {
        this.repo = repo;
    }

    public List<LecturerCourseClass> getAll() { return repo.findAll(); }

    public LecturerCourseClass getById(UUID id) { return repo.findById(id).orElse(null); }

    public LecturerCourseClass create(LecturerCourseClass lcc) { return repo.save(lcc); }

    public LecturerCourseClass update(UUID id, LecturerCourseClass updated) {
        LecturerCourseClass old = getById(id);
        if (old == null) return null;
        old.setEmployeeId(updated.getEmployeeId());
        old.setCourseClassId(updated.getCourseClassId());
        old.setRole(updated.getRole());
        old.setUpdatedAt(updated.getUpdatedAt());
        old.setUpdatedBy(updated.getUpdatedBy());
        old.setIsActive(updated.getIsActive());
        return repo.save(old);
    }

    public void delete(UUID id) { repo.deleteById(id); }

    public List<LecturerCourseClass> getByEmployee(UUID employeeId) { return repo.findByEmployeeId(employeeId); }

    public List<LecturerCourseClass> getByCourseClass(UUID courseClassId) { return repo.findByCourseClassId(courseClassId); }

    public List<LecturerCourseClass> getByRole(String role) { return repo.findByRole(role); }

    public List<LecturerCourseClass> getActive() { return repo.findByIsActive(true); }
}
