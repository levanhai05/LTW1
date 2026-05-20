package com.example.demo.student_course_sections.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.student_course_sections.model.entity.StudentCourseSection;
import com.example.demo.student_course_sections.repository.StudentCourseSectionRepository;

@Service
public class StudentCourseSectionService {

    private final StudentCourseSectionRepository repo;

    public StudentCourseSectionService(StudentCourseSectionRepository repo) {
        this.repo = repo;
    }

    public List<StudentCourseSection> getAll() {
        return repo.findAll();
    }

    public StudentCourseSection getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public StudentCourseSection create(StudentCourseSection scs) {
        return repo.save(scs);
    }

    public StudentCourseSection update(UUID id, StudentCourseSection updated) {
        StudentCourseSection old = getById(id);
        if (old == null)
            return null;
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

    public void delete(UUID id) {
        repo.deleteById(id);
    }

    public List<StudentCourseSection> getByStudent(UUID studentId) {
        return repo.findByStudentId(studentId);
    }

    public List<StudentCourseSection> getByCourseSection(UUID courseSectionId) {
        return repo.findByCourseSectionId(courseSectionId);
    }

    public List<StudentCourseSection> getByStatus(String status) {
        return repo.findByStatus(status);
    }

    public List<StudentCourseSection> getActive() {
        return repo.findByIsActive(true);
    }

    // Fix: thử parse keyword thành UUID để tìm theo studentId hoặc courseSectionId,
    // nếu không phải UUID thì tìm theo note/status
    public List<StudentCourseSection> search(String keyword) {
        try {
            UUID id = UUID.fromString(keyword);
            // Ưu tiên tìm theo courseSectionId trước
            List<StudentCourseSection> byCS = repo.findByCourseSectionId(id);
            if (!byCS.isEmpty())
                return byCS;
            return repo.findByStudentId(id);
        } catch (IllegalArgumentException e) {
            // Không phải UUID → tìm theo note hoặc status
            return repo.findByKeyword(keyword);
        }
    }
}