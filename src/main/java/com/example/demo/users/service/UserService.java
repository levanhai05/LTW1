package com.example.demo.users.service;

import java.time.LocalDateTime;
import java.util.List;
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

    /**
     * Tạo user mới — bao gồm fullName để tránh lỗi NOT NULL trên DB.
     */
    public User createUser(String username, String password, String fullName,
            String email, String phone, String avatarUrl) {
        User u = new User();
        u.setUsername(username);
        u.setPassword(password); // TODO: encode password with BCrypt trước khi deploy
        u.setFullName(fullName);
        u.setEmail(email);
        u.setPhone(phone);
        u.setAvatarUrl(avatarUrl);
        u.setIsActive(true);
        u.setCreatedAt(LocalDateTime.now());
        u.setUpdatedAt(LocalDateTime.now());
        return userRepo.save(u);
    }

    public User assignRole(UUID userId, UUID roleId) {
        User u = userRepo.findById(userId).orElseThrow();
        Role r = roleRepo.findById(roleId).orElseThrow();
        u.getRoles().add(r);
        return userRepo.save(u);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void deleteById(UUID id) {
        userRepo.deleteById(id);
    }
}