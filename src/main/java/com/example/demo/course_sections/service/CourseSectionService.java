package com.example.demo.course_sections.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.course_sections.model.entity.CourseSection;
import com.example.demo.course_sections.repository.CourseSectionRepository;

@Service
public class CourseSectionService {

    private final CourseSectionRepository repo;

    public CourseSectionService(CourseSectionRepository repo) {
        this.repo = repo;
    }

    public List<CourseSection> getAll() { return repo.findAll(); }

    public CourseSection getById(UUID id) { return repo.findById(id).orElse(null); }

    public CourseSection create(CourseSection cs) { return repo.save(cs); }

    public CourseSection update(UUID id, CourseSection updated) {
        CourseSection old = getById(id);
        if (old == null) return null;
        old.setCode(updated.getCode());
        old.setName(updated.getName());
        old.setAcademicYear(updated.getAcademicYear());
        old.setCourseId(updated.getCourseId());
        old.setSemesterId(updated.getSemesterId());
        old.setEmployeeId(updated.getEmployeeId());
        old.setRoomId(updated.getRoomId());
        old.setBuildingId(updated.getBuildingId());
        old.setMaxStudents(updated.getMaxStudents());
        old.setMinStudents(updated.getMinStudents());
        old.setClassType(updated.getClassType());
        old.setStatus(updated.getStatus());
        old.setRegistrationStart(updated.getRegistrationStart());
        old.setRegistrationEnd(updated.getRegistrationEnd());
        old.setNote(updated.getNote());
        old.setUpdatedAt(updated.getUpdatedAt());
        old.setUpdatedBy(updated.getUpdatedBy());
        old.setIsActive(updated.getIsActive());
        return repo.save(old);
    }

    public void delete(UUID id) { repo.deleteById(id); }

    public List<CourseSection> search(String name) { return repo.findByCodeContainingIgnoreCase(name); }

    public List<CourseSection> getBySemester(UUID semesterId) { return repo.findBySemesterId(semesterId); }

    public List<CourseSection> getByCourse(UUID courseId) { return repo.findByCourseId(courseId); }

    public List<CourseSection> getByStatus(String status) { return repo.findByStatus(status); }

    public List<CourseSection> getActive() { return repo.findByIsActive(true); }
}