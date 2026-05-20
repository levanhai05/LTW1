package com.example.demo.users.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.users.model.entity.User;
import com.example.demo.users.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam(defaultValue = "") String fullName,
            @RequestParam(defaultValue = "") String email,
            @RequestParam(defaultValue = "") String phone,
            @RequestParam(defaultValue = "") String avatarUrl) {
        String name = (fullName != null && !fullName.isBlank()) ? fullName : username;
        return userService.createUser(username, password, name, email, phone, avatarUrl);
    }

    @PutMapping("/{id}")
    public User update(
            @PathVariable UUID id,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String avatarUrl,
            @RequestParam(required = false) Boolean isActive) {
        return userService.updateUser(id, username, password, fullName, email, phone, avatarUrl, isActive);
    }

    // Gán 1 role (giữ lại cho tương thích)
    @PostMapping("/{userId}/roles/{roleId}")
    public User assignRole(@PathVariable UUID userId,
            @PathVariable UUID roleId) {
        return userService.assignRole(userId, roleId);
    }

    // Gán nhiều role cùng lúc (thay thế toàn bộ)
    @PutMapping("/{userId}/roles")
    public User setRoles(@PathVariable UUID userId,
            @RequestBody List<UUID> roleIds) {
        return userService.setRoles(userId, roleIds);
    }

    // Xóa 1 role khỏi user
    @DeleteMapping("/{userId}/roles/{roleId}")
    public User removeRole(@PathVariable UUID userId,
            @PathVariable UUID roleId) {
        return userService.removeRole(userId, roleId);
    }

    @GetMapping
    public List<User> list() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.deleteById(id);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable UUID id) {
        return userService.findById(id);
    }
}
