package com.example.demo.semesters.service;

import com.example.demo.semesters.model.entity.Semester;
import com.example.demo.semesters.repository.SemesterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SemesterService {

    private final SemesterRepository repo;

    public SemesterService(SemesterRepository repo) {
        this.repo = repo;
    }

    public List<Semester> getAll() { return repo.findAll(); }

    public Semester getById(UUID id) { return repo.findById(id).orElse(null); }

    public Semester create(Semester semester) { return repo.save(semester); }

    public Semester update(UUID id, Semester updated) {
        Semester old = getById(id);
        if (old == null) return null;
        old.setCode(updated.getCode());
        old.setName(updated.getName());
        old.setSchoolYearId(updated.getSchoolYearId());
        old.setSchoolYearName(updated.getSchoolYearName());
        old.setStartDate(updated.getStartDate());
        old.setEndDate(updated.getEndDate());
        old.setUpdatedAt(updated.getUpdatedAt());
        old.setUpdatedBy(updated.getUpdatedBy());
        old.setIsActive(updated.getIsActive());
        return repo.save(old);
    }

    public void delete(UUID id) { repo.deleteById(id); }

    public List<Semester> search(String name) { return repo.findByNameContainingIgnoreCase(name); }

    public List<Semester> getBySchoolYear(UUID schoolYearId) { return repo.findBySchoolYearId(schoolYearId); }

    public List<Semester> getActive() { return repo.findByIsActive(true); }
}
