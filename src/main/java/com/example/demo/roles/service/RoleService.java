package com.example.demo.roles.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.roles.model.entity.Role;
import com.example.demo.roles.repository.RoleRepository;

@Service
public class RoleService {

    private final RoleRepository roleRepo;

    public RoleService(RoleRepository roleRepo) {
        this.roleRepo = roleRepo;
    }

    public Role createRole(Role role) {
        if (role.getCreatedAt() == null)
            role.setCreatedAt(LocalDateTime.now());
        role.setUpdatedAt(LocalDateTime.now());
        return roleRepo.save(role);
    }

    public Role updateRole(UUID id, Role incoming) {
        Role r = roleRepo.findById(id).orElseThrow();
        if (incoming.getCode() != null)
            r.setCode(incoming.getCode());
        if (incoming.getName() != null)
            r.setName(incoming.getName());
        if (incoming.getDescription() != null)
            r.setDescription(incoming.getDescription());
        if (incoming.getIsSystem() != null)
            r.setIsSystem(incoming.getIsSystem());
        if (incoming.getIsActive() != null)
            r.setIsActive(incoming.getIsActive());
        r.setUpdatedAt(LocalDateTime.now());
        return roleRepo.save(r);
    }
}
