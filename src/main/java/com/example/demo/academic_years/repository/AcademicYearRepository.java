package com.example.demo.academic_years.repository;

import com.example.demo.academic_years.model.entity.AcademicYear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AcademicYearRepository extends JpaRepository<AcademicYear, UUID> {
    List<AcademicYear> findByNameContainingIgnoreCase(String name);
    List<AcademicYear> findByIsActive(Boolean isActive);
}
