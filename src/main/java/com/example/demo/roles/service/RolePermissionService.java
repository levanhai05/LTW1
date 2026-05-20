package com.example.demo.roles.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.permissions.model.entity.Permission;
import com.example.demo.permissions.repository.PermissionRepository;
import com.example.demo.roles.model.entity.RolePermission;
import com.example.demo.roles.repository.RolePermissionRepository;

@Service
public class RolePermissionService {

    private final RolePermissionRepository repository;
    private final PermissionRepository permissionRepository;

    public RolePermissionService(RolePermissionRepository repository,
            PermissionRepository permissionRepository) {
        this.repository = repository;
        this.permissionRepository = permissionRepository;
    }

    /** Gán 1 permission, bỏ qua nếu đã tồn tại */
    public RolePermission assignPermission(UUID roleId, UUID permissionId) {
        boolean exists = repository.findByRoleId(roleId).stream()
                .anyMatch(rp -> rp.getPermissionId().equals(permissionId));
        if (exists) {
            return repository.findByRoleId(roleId).stream()
                    .filter(rp -> rp.getPermissionId().equals(permissionId))
                    .findFirst().orElseThrow();
        }
        RolePermission rp = new RolePermission(roleId, permissionId);
        rp.setCreatedAt(LocalDateTime.now());
        rp.setIsActive(true);
        return repository.save(rp);
    }

    @Transactional
    public void removePermission(UUID roleId, UUID permissionId) {
        repository.deleteByRoleIdAndPermissionId(roleId, permissionId);
    }

    public List<RolePermission> getPermissionsByRoleId(UUID roleId) {
        return repository.findByRoleId(roleId);
    }

    /** Trả về Permission objects đầy đủ (code, name...) */
    public List<Permission> getPermissionObjectsByRoleId(UUID roleId) {
        List<Permission> result = new ArrayList<>();
        for (RolePermission rp : repository.findByRoleId(roleId)) {
            permissionRepository.findById(rp.getPermissionId()).ifPresent(result::add);
        }
        return result;
    }

    /** Thay thế toàn bộ permissions của role */
    @Transactional
    public void setPermissions(UUID roleId, List<UUID> permissionIds) {
        repository.deleteAll(repository.findByRoleId(roleId));
        for (UUID permId : permissionIds) {
            RolePermission rp = new RolePermission(roleId, permId);
            rp.setCreatedAt(LocalDateTime.now());
            rp.setIsActive(true);
            repository.save(rp);
        }
    }
}
