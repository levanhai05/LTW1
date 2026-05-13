package com.example.demo.school_years.repository;

import com.example.demo.school_years.model.entity.SchoolYear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SchoolYearRepository extends JpaRepository<SchoolYear, UUID> {
    List<SchoolYear> findByNameContainingIgnoreCase(String name);
    List<SchoolYear> findByIsActive(Boolean isActive);
}
