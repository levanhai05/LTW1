package com.example.demo.student_course_sections.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.student_course_sections.model.entity.StudentCourseSection;

public interface StudentCourseSectionRepository extends JpaRepository<StudentCourseSection, UUID> {
    List<StudentCourseSection> findByStudentId(UUID studentId);
    List<StudentCourseSection> findByCourseSectionId(UUID courseSectionId);
    List<StudentCourseSection> findByStatus(String status);
    List<StudentCourseSection> findByStudentIdAndCourseSectionId(UUID studentId, UUID courseSectionId);
    List<StudentCourseSection> findByIsActive(Boolean isActive);

    @org.springframework.data.jpa.repository.Query(
        "SELECT s FROM StudentCourseSection s WHERE " +
        "CAST(s.studentId AS string) LIKE %:kw% OR " +
        "CAST(s.courseSectionId AS string) LIKE %:kw%"
    )
    List<StudentCourseSection> findByStudentIdContainingOrCourseSectionIdContaining(
        @org.springframework.data.repository.query.Param("kw") String kw
    );
}