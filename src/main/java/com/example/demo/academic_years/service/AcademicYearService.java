package com.example.demo.academic_years.service;

import com.example.demo.academic_years.model.entity.AcademicYear;
import com.example.demo.academic_years.repository.AcademicYearRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AcademicYearService {

    private final AcademicYearRepository repo;

    public AcademicYearService(AcademicYearRepository repo) {
        this.repo = repo;
    }

    public List<AcademicYear> getAll() {
        return repo.findAll();
    }

    public AcademicYear getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public AcademicYear create(AcademicYear academicYear) {
        return repo.save(academicYear);
    }

    public AcademicYear update(UUID id, AcademicYear updated) {
        AcademicYear old = getById(id);
        if (old == null) return null;
        old.setCode(updated.getCode());
        old.setName(updated.getName());
        old.setYear(updated.getYear());
        old.setDescription(updated.getDescription());
        old.setStartDate(updated.getStartDate());
        old.setEndDate(updated.getEndDate());
        old.setUpdatedAt(updated.getUpdatedAt());
        old.setUpdatedBy(updated.getUpdatedBy());
        old.setIsActive(updated.getIsActive());
        return repo.save(old);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

    public List<AcademicYear> search(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    public List<AcademicYear> getActive() {
        return repo.findByIsActive(true);
    }
}
