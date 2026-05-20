package com.example.demo.students.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user_id;

    @Column(name = "code", length = 20)
    private String code;

    @Column(name = "full_name", length = 100)
    private String fullname;

    @Column(name = "date_of_birth")
    private LocalDate date_of_birth;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "personal_identification_number", length = 20)
    private String personal_identification_number;

    @Column(name = "date_of_issue")
    private LocalDate date_of_issue;

    @Column(name = "card_place", length = 100)
    private String card_place;

    @Column(name = "address", length = 300)
    private String address;

    @Column(name = "current_address", length = 300)
    private String current_address;

    private Integer academic_year_year;
    private Integer department_id;
    private Integer major_id;
    private Integer training_program_id;

    @Column(name = "status", length = 50)
    private String status;

    private Integer student_classe_id;

    @Column(name = "admission_year")
    private Integer admission_year;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "deleted_by")
    private Integer deletedBy;

    @Column(name = "is_active")
    private Boolean isActive;

    public Student() {}

    // ---- Getters & Setters ----

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUser_id() { return user_id; }
    public void setUser_id(Integer user_id) { this.user_id = user_id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public LocalDate getDate_of_birth() { return date_of_birth; }
    public void setDate_of_birth(LocalDate date_of_birth) { this.date_of_birth = date_of_birth; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPersonal_identification_number() { return personal_identification_number; }
    public void setPersonal_identification_number(String personal_identification_number) { this.personal_identification_number = personal_identification_number; }

    public LocalDate getDate_of_issue() { return date_of_issue; }
    public void setDate_of_issue(LocalDate date_of_issue) { this.date_of_issue = date_of_issue; }

    public String getCard_place() { return card_place; }
    public void setCard_place(String card_place) { this.card_place = card_place; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCurrent_address() { return current_address; }
    public void setCurrent_address(String current_address) { this.current_address = current_address; }

    public Integer getAcademic_year_year() { return academic_year_year; }
    public void setAcademic_year_year(Integer academic_year_year) { this.academic_year_year = academic_year_year; }

    public Integer getDepartment_id() { return department_id; }
    public void setDepartment_id(Integer department_id) { this.department_id = department_id; }

    public Integer getMajor_id() { return major_id; }
    public void setMajor_id(Integer major_id) { this.major_id = major_id; }

    public Integer getTraining_program_id() { return training_program_id; }
    public void setTraining_program_id(Integer training_program_id) { this.training_program_id = training_program_id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getStudent_classe_id() { return student_classe_id; }
    public void setStudent_classe_id(Integer student_classe_id) { this.student_classe_id = student_classe_id; }

    public Integer getAdmission_year() { return admission_year; }
    public void setAdmission_year(Integer admission_year) { this.admission_year = admission_year; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public Integer getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(Integer updatedBy) { this.updatedBy = updatedBy; }

    public LocalDateTime getDeletedAt() { return deletedAt; }
    public void setDeletedAt(LocalDateTime deletedAt) { this.deletedAt = deletedAt; }

    public Integer getDeletedBy() { return deletedBy; }
    public void setDeletedBy(Integer deletedBy) { this.deletedBy = deletedBy; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}
