package com.example.demo.students.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.students.model.entity.Student;
import com.example.demo.students.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public Student create(Student student) {
        if (student.getCreatedAt() == null)
            student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return repo.save(student);
    }

    public Student update(UUID id, Student incoming) {
        Student old = getById(id);
        if (old == null)
            return null;

        // Cập nhật toàn bộ các trường có thể sửa
        if (incoming.getCode() != null)
            old.setCode(incoming.getCode());
        if (incoming.getFullname() != null)
            old.setFullname(incoming.getFullname());
        if (incoming.getGender() != null)
            old.setGender(incoming.getGender());
        if (incoming.getDate_of_birth() != null)
            old.setDate_of_birth(incoming.getDate_of_birth());
        if (incoming.getAddress() != null)
            old.setAddress(incoming.getAddress());
        if (incoming.getCurrent_address() != null)
            old.setCurrent_address(incoming.getCurrent_address());
        if (incoming.getStatus() != null)
            old.setStatus(incoming.getStatus());
        if (incoming.getUser_id() != null)
            old.setUser_id(incoming.getUser_id());
        if (incoming.getIsActive() != null)
            old.setIsActive(incoming.getIsActive());

        // Các trường định danh / phân loại
        if (incoming.getAcademic_year_year() != null)
            old.setAcademic_year_year(incoming.getAcademic_year_year());
        if (incoming.getDepartment_id() != null)
            old.setDepartment_id(incoming.getDepartment_id());
        if (incoming.getMajor_id() != null)
            old.setMajor_id(incoming.getMajor_id());
        if (incoming.getTraining_program_id() != null)
            old.setTraining_program_id(incoming.getTraining_program_id());
        if (incoming.getStudent_classe_id() != null)
            old.setStudent_classe_id(incoming.getStudent_classe_id());
        if (incoming.getAdmission_year() != null)
            old.setAdmission_year(incoming.getAdmission_year());

        // CMND / Căn cước
        if (incoming.getPersonal_identification_number() != null)
            old.setPersonal_identification_number(incoming.getPersonal_identification_number());
        if (incoming.getDate_of_issue() != null)
            old.setDate_of_issue(incoming.getDate_of_issue());
        if (incoming.getCard_place() != null)
            old.setCard_place(incoming.getCard_place());

        old.setUpdatedAt(LocalDateTime.now());
        return repo.save(old);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

    public List<Student> search(String fullname) {
        return repo.findByFullnameContainingIgnoreCase(fullname);
    }
}