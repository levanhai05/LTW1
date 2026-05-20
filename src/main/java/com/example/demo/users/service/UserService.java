package com.example.demo.users.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.roles.model.entity.Role;
import com.example.demo.roles.repository.RoleRepository;
import com.example.demo.users.model.entity.User;
import com.example.demo.users.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    public UserService(UserRepository userRepo, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public User createUser(String username, String password, String fullName,
            String email, String phone, String avatarUrl) {
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setFullName((fullName != null && !fullName.isBlank()) ? fullName : username);
        u.setEmail(email);
        u.setPhone(phone);
        u.setAvatarUrl(avatarUrl);
        u.setIsActive(true);
        u.setCreatedAt(LocalDateTime.now());
        u.setUpdatedAt(LocalDateTime.now());
        return userRepo.save(u);
    }

    public User updateUser(UUID id, String username, String password, String fullName,
            String email, String phone, String avatarUrl, Boolean isActive) {
        User u = userRepo.findById(id).orElseThrow();
        if (username != null && !username.isBlank())
            u.setUsername(username);
        if (password != null && !password.isBlank())
            u.setPassword(password);
        if (fullName != null && !fullName.isBlank())
            u.setFullName(fullName);
        if (email != null)
            u.setEmail(email);
        if (phone != null)
            u.setPhone(phone);
        if (avatarUrl != null)
            u.setAvatarUrl(avatarUrl);
        if (isActive != null)
            u.setIsActive(isActive);
        u.setUpdatedAt(LocalDateTime.now());
        return userRepo.save(u);
    }

    public User assignRole(UUID userId, UUID roleId) {
        User u = userRepo.findById(userId).orElseThrow();
        Role r = roleRepo.findById(roleId).orElseThrow();
        u.getRoles().add(r);
        return userRepo.save(u);
    }

    public User removeRole(UUID userId, UUID roleId) {
        User u = userRepo.findById(userId).orElseThrow();
        u.getRoles().removeIf(r -> r.getId().equals(roleId));
        return userRepo.save(u);
    }

    /** Thay thế toàn bộ roles của user */
    public User setRoles(UUID userId, List<UUID> roleIds) {
        User u = userRepo.findById(userId).orElseThrow();
        Set<Role> newRoles = new HashSet<>();
        for (UUID rid : roleIds) {
            roleRepo.findById(rid).ifPresent(newRoles::add);
        }
        u.setRoles(newRoles);
        return userRepo.save(u);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void deleteById(UUID id) {
        userRepo.deleteById(id);
    }

    public User findById(UUID id) {
        return userRepo.findById(id).orElseThrow();
    }
}