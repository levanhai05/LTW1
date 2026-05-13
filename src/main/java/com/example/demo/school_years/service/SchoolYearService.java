package com.example.demo.school_years.service;

import com.example.demo.school_years.model.entity.SchoolYear;
import com.example.demo.school_years.repository.SchoolYearRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SchoolYearService {

    private final SchoolYearRepository repo;

    public SchoolYearService(SchoolYearRepository repo) {
        this.repo = repo;
    }

    public List<SchoolYear> getAll() { return repo.findAll(); }

    public SchoolYear getById(UUID id) { return repo.findById(id).orElse(null); }

    public SchoolYear create(SchoolYear schoolYear) { return repo.save(schoolYear); }

    public SchoolYear update(UUID id, SchoolYear updated) {
        SchoolYear old = getById(id);
        if (old == null) return null;
        old.setCode(updated.getCode());
        old.setName(updated.getName());
        old.setDescription(updated.getDescription());
        old.setNote(updated.getNote());
        old.setStartDate(updated.getStartDate());
        old.setEndDate(updated.getEndDate());
        old.setUpdatedAt(updated.getUpdatedAt());
        old.setUpdatedBy(updated.getUpdatedBy());
        old.setIsActive(updated.getIsActive());
        return repo.save(old);
    }

    public void delete(UUID id) { repo.deleteById(id); }

    public List<SchoolYear> search(String name) { return repo.findByNameContainingIgnoreCase(name); }

    public List<SchoolYear> getActive() { return repo.findByIsActive(true); }
}
