package com.example.demo.lecturer_course_classes.repository;

import com.example.demo.lecturer_course_classes.model.entity.LecturerCourseClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LecturerCourseClassRepository extends JpaRepository<LecturerCourseClass, UUID> {
    List<LecturerCourseClass> findByEmployeeId(UUID employeeId);
    List<LecturerCourseClass> findByCourseClassId(UUID courseClassId);
    List<LecturerCourseClass> findByRole(String role);
    List<LecturerCourseClass> findByIsActive(Boolean isActive);
}
