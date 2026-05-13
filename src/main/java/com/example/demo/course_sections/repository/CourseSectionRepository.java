package com.example.demo.course_sections.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.course_sections.model.entity.CourseSection;

public interface CourseSectionRepository extends JpaRepository<CourseSection, UUID> {
    List<CourseSection> findByCodeContainingIgnoreCase(String code);
    List<CourseSection> findBySemesterId(UUID semesterId);
    List<CourseSection> findByCourseId(UUID courseId);
    List<CourseSection> findByStatus(String status);
    List<CourseSection> findByIsActive(Boolean isActive);
}