package com.example.demo.roles.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id @GeneratedValue @UuidGenerator
    @Column(columnDefinition = "UNIQUEIDENTIFIER", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "code",        length = 50)  private String code;
    @Column(name = "name",        length = 100) private String name;
    @Column(name = "description", length = 255) private String description;
    @Column(name = "is_system")                 private Boolean isSystem;
    @Column(name = "is_active")                 private Boolean isActive;
    @Column(name = "created_at")                private LocalDateTime createdAt;
    @Column(name = "updated_at")                private LocalDateTime updatedAt;
    @Column(name = "created_by")                private UUID createdBy;
    @Column(name = "updated_by")                private UUID updatedBy;
    @Column(name = "deleted_at")                private LocalDateTime deletedAt;
    @Column(name = "deleted_by")                private UUID deletedBy;

    // Bỏ @ManyToMany — dùng RolePermissionService để tránh xung đột bảng

    public Role() {}

    public UUID getId()                        { return id; }
    public void setId(UUID id)                 { this.id = id; }
    public String getCode()                    { return code; }
    public void setCode(String v)              { this.code = v; }
    public String getName()                    { return name; }
    public void setName(String v)              { this.name = v; }
    public String getDescription()             { return description; }
    public void setDescription(String v)       { this.description = v; }
    public Boolean getIsSystem()               { return isSystem; }
    public void setIsSystem(Boolean v)         { this.isSystem = v; }
    public Boolean getIsActive()               { return isActive; }
    public void setIsActive(Boolean v)         { this.isActive = v; }
    public LocalDateTime getCreatedAt()        { return createdAt; }
    public void setCreatedAt(LocalDateTime v)  { this.createdAt = v; }
    public LocalDateTime getUpdatedAt()        { return updatedAt; }
    public void setUpdatedAt(LocalDateTime v)  { this.updatedAt = v; }
    public UUID getCreatedBy()                 { return createdBy; }
    public void setCreatedBy(UUID v)           { this.createdBy = v; }
    public UUID getUpdatedBy()                 { return updatedBy; }
    public void setUpdatedBy(UUID v)           { this.updatedBy = v; }
    public LocalDateTime getDeletedAt()        { return deletedAt; }
    public void setDeletedAt(LocalDateTime v)  { this.deletedAt = v; }
    public UUID getDeletedBy()                 { return deletedBy; }
    public void setDeletedBy(UUID v)           { this.deletedBy = v; }
}
