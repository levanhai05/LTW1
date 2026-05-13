package com.example.demo.users.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        // Nếu fullName trống thì dùng username làm fallback
        String name = (fullName != null && !fullName.isBlank()) ? fullName : username;
        return userService.createUser(username, password, name, email, phone, avatarUrl);
    }

    @PostMapping("/{userId}/roles/{roleId}")
    public User assignRole(@PathVariable UUID userId,
            @PathVariable UUID roleId) {
        return userService.assignRole(userId, roleId);
    }

    @GetMapping
    public List<User> list() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.deleteById(id);
    }
}