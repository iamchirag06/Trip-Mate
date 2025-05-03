package com.example.demo.service;

import com.example.demo.model.UserCredentials;
import com.example.demo.repository.UserCredentialsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserCredentialsService {
    private final UserCredentialsRepository repo;

    public UserCredentialsService(UserCredentialsRepository repo) {
        this.repo = repo;
    }

    public List<UserCredentials> getAll() {
        return repo.findAll();
    }

    public Optional<UserCredentials> getById(String id) {
        return repo.findById(id);
    }

    public UserCredentials save(UserCredentials user) {
        // No password hashing
        return repo.save(user);
    }

    public Optional<UserCredentials> update(String id, UserCredentials updated) {
        return repo.findById(id).map(existing -> {
            updated.setId(id);
            // No password hashing
            return repo.save(updated);
        });
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}
