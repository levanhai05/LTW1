package com.example.demo.semesters.repository;

import com.example.demo.semesters.model.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SemesterRepository extends JpaRepository<Semester, UUID> {
    List<Semester> findByNameContainingIgnoreCase(String name);
    List<Semester> findBySchoolYearId(UUID schoolYearId);
    List<Semester> findByIsActive(Boolean isActive);
}
