package com.example.demo.controller;

import com.example.demo.model.UserCredentials;
import com.example.demo.service.UserCredentialsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sign")
public class SignController {
    private final UserCredentialsService userCredentialsService;

    public SignController(UserCredentialsService userCredentialsService) {
        this.userCredentialsService = userCredentialsService;
    }

    @GetMapping
    public ResponseEntity<List<UserCredentials>> getAllUsers() {
        return ResponseEntity.ok(userCredentialsService.getAll());
    }

    @PostMapping
    public ResponseEntity<UserCredentials> registerUser(@Valid @RequestBody UserCredentials user) {
        UserCredentials savedUser = userCredentialsService.save(user);
        return ResponseEntity.status(201).body(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCredentials> getById(@PathVariable String id) {
        return userCredentialsService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserCredentials> updateUser(@PathVariable String id, @Valid @RequestBody UserCredentials user) {
        return userCredentialsService.update(id, user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userCredentialsService.delete(id);
        return ResponseEntity.ok("Deleted user with ID: " + id);
    }
}
