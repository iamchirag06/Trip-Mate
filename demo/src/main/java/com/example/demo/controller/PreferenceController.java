package com.example.demo.controller;

import com.example.demo.model.Preference;
import com.example.demo.service.PreferenceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preferences")
public class PreferenceController {

    private final PreferenceService service;

    public PreferenceController(PreferenceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Preference> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Preference> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Preference> create(@Valid @RequestBody Preference preference) {
        return ResponseEntity.status(201).body(service.save(preference));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Preference> update(@PathVariable String id, @Valid @RequestBody Preference preference) {
        return service.update(id, preference)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted preference with ID: " + id);
    }
}
