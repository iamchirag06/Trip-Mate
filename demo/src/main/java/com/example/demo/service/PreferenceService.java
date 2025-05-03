package com.example.demo.service;

import com.example.demo.model.Preference;
import com.example.demo.repository.PreferenceRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PreferenceService {
    private final PreferenceRepository repo;

    public PreferenceService(PreferenceRepository repo) {
        this.repo = repo;
    }

    public List<Preference> getAll() {
        return repo.findAll();
    }

    public Optional<Preference> getById(String id) {
        return repo.findById(id);
    }

    public Preference save(Preference pref) {
        return repo.save(pref);
    }

    public Optional<Preference> update(String id, Preference updated) {
        return repo.findById(id).map(existing -> {
            updated.setId(id);
            return repo.save(updated);
        });
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}
