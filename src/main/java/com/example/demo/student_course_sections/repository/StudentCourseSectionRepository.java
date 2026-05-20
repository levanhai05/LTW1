package com.example.demo.student_course_sections.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.student_course_sections.model.entity.StudentCourseSection;

public interface StudentCourseSectionRepository extends JpaRepository<StudentCourseSection, UUID> {
    List<StudentCourseSection> findByStudentId(UUID studentId);

    List<StudentCourseSection> findByCourseSectionId(UUID courseSectionId);

    List<StudentCourseSection> findByStatus(String status);

    List<StudentCourseSection> findByStudentIdAndCourseSectionId(UUID studentId, UUID courseSectionId);

    List<StudentCourseSection> findByIsActive(Boolean isActive);

    // Fix: tách thành 2 method riêng thay vì CAST UUID AS string (không ổn định
    // trên SQL Server/H2)
    List<StudentCourseSection> findByStudentId(UUID studentId, org.springframework.data.domain.Pageable pageable);

    @Query("SELECT s FROM StudentCourseSection s WHERE " +
            "s.note LIKE %:kw% OR s.status LIKE %:kw%")
    List<StudentCourseSection> findByKeyword(@Param("kw") String kw);
}