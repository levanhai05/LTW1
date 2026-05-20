package com.example.demo.students.repository;

import com.example.demo.students.model.entity.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByFullnameContainingIgnoreCase(String fullname);
}
