package com.example.demo.permissions.controller;

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
import com.example.demo.permissions.repository.PermissionRepository;

@RestController
@RequestMapping("/api/permissions")
public class PermissionApiController {

    private final PermissionRepository repo;

    public PermissionApiController(PermissionRepository repo) {
        this.repo = repo;
    }

    // CREATE
    @PostMapping
    public Permission create(@RequestBody Permission p) {
        return repo.save(p);
    }

    // GET ALL
    @GetMapping
    public List<Permission> list() {
        return repo.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Permission getById(@PathVariable UUID id) {
        return repo.findById(id).orElseThrow();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Permission update(
            @PathVariable UUID id,
            @RequestBody Permission p) {

        Permission old = repo.findById(id).orElseThrow();

        old.setCode(p.getCode());
        old.setName(p.getName());
        old.setDescription(p.getDescription());
        old.setModule(p.getModule());
        old.setIsActive(p.getIsActive());

        return repo.save(old);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        repo.deleteById(id);
    }
}