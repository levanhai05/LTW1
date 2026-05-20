package com.example.demo.roles.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.permissions.model.entity.Permission;
import com.example.demo.roles.model.entity.Role;
import com.example.demo.roles.model.entity.RolePermission;
import com.example.demo.roles.repository.RoleRepository;
import com.example.demo.roles.service.RolePermissionService;
import com.example.demo.roles.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleApiController {

    private final RoleService roleService;
    private final RoleRepository roleRepository;
    private final RolePermissionService rolePermissionService;

    public RoleApiController(RoleService roleService,
            RoleRepository roleRepository,
            RolePermissionService rolePermissionService) {
        this.roleService = roleService;
        this.roleRepository = roleRepository;
        this.rolePermissionService = rolePermissionService;
    }

    /** GET ALL — trả về kèm permissions */
    @GetMapping
    public List<RoleDTO> list() {
        List<RoleDTO> result = new ArrayList<>();
        for (Role r : roleRepository.findAll()) {
            result.add(new RoleDTO(r,
                    rolePermissionService.getPermissionObjectsByRoleId(r.getId())));
        }
        return result;
    }

    @GetMapping("/{id}")
    public RoleDTO getById(@PathVariable UUID id) {
        Role r = roleRepository.findById(id).orElseThrow();
        return new RoleDTO(r, rolePermissionService.getPermissionObjectsByRoleId(id));
    }

    @PostMapping
    public RoleDTO create(@RequestBody Role role) {
        Role saved = roleService.createRole(role);
        return new RoleDTO(saved, List.of());
    }

    @PutMapping("/{id}")
    public RoleDTO update(@PathVariable UUID id, @RequestBody Role role) {
        Role saved = roleService.updateRole(id, role);
        return new RoleDTO(saved,
                rolePermissionService.getPermissionObjectsByRoleId(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        roleRepository.deleteById(id);
    }

    /** Thay thế toàn bộ permissions */
    @PutMapping("/{roleId}/permissions")
    public RoleDTO setPermissions(@PathVariable UUID roleId,
            @RequestBody List<UUID> permissionIds) {
        rolePermissionService.setPermissions(roleId, permissionIds);
        Role r = roleRepository.findById(roleId).orElseThrow();
        return new RoleDTO(r,
                rolePermissionService.getPermissionObjectsByRoleId(roleId));
    }

    /** Gán 1 permission */
    @PostMapping("/{roleId}/permissions/{permId}")
    public RolePermission addPermission(@PathVariable UUID roleId,
            @PathVariable UUID permId) {
        return rolePermissionService.assignPermission(roleId, permId);
    }

    /** Xóa 1 permission */
    @DeleteMapping("/{roleId}/permissions/{permId}")
    public void removePermission(@PathVariable UUID roleId,
            @PathVariable UUID permId) {
        rolePermissionService.removePermission(roleId, permId);
    }

    // ── DTO: Role + permissions gộp chung để trả về frontend ──
    public static class RoleDTO {
        public UUID id;
        public String code, name, description;
        public Boolean isSystem, isActive;
        public java.time.LocalDateTime createdAt, updatedAt;
        public List<Permission> permissions;

        public RoleDTO(Role r, List<Permission> perms) {
            this.id = r.getId();
            this.code = r.getCode();
            this.name = r.getName();
            this.description = r.getDescription();
            this.isSystem = r.getIsSystem();
            this.isActive = r.getIsActive();
            this.createdAt = r.getCreatedAt();
            this.updatedAt = r.getUpdatedAt();
            this.permissions = perms;
        }
    }
}
