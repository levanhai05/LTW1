package com.example.demo.student_course_sections.service;

import com.example.demo.student_course_sections.model.entity.StudentCourseSection;
import com.example.demo.student_course_sections.repository.StudentCourseSectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentCourseSectionService {

    private final StudentCourseSectionRepository repo;

    public StudentCourseSectionService(StudentCourseSectionRepository repo) {
        this.repo = repo;
    }

    public List<StudentCourseSection> getAll() { return repo.findAll(); }

    public StudentCourseSection getById(UUID id) { return repo.findById(id).orElse(null); }

    public StudentCourseSection create(StudentCourseSection scs) { return repo.save(scs); }

    public StudentCourseSection update(UUID id, StudentCourseSection updated) {
        StudentCourseSection old = getById(id);
        if (old == null) return null;
        old.setStudentId(updated.getStudentId());
        old.setCourseSectionId(updated.getCourseSectionId());
        old.setStatus(updated.getStatus());
        old.setRegisteredAt(updated.getRegisteredAt());
        old.setNote(updated.getNote());
        old.setUpdatedAt(updated.getUpdatedAt());
        old.setUpdatedBy(updated.getUpdatedBy());
        old.setIsActive(updated.getIsActive());
        return repo.save(old);
    }

    public void delete(UUID id) { repo.deleteById(id); }

    public List<StudentCourseSection> getByStudent(UUID studentId) { return repo.findByStudentId(studentId); }

    public List<StudentCourseSection> getByCourseSection(UUID courseSectionId) {
        return repo.findByCourseSectionId(courseSectionId);
    }

    public List<StudentCourseSection> getByStatus(String status) { return repo.findByStatus(status); }

    public List<StudentCourseSection> getActive() { return repo.findByIsActive(true); }

    public List<StudentCourseSection> search(String keyword) {
        return repo.findByStudentIdContainingOrCourseSectionIdContaining(keyword);
    }
}