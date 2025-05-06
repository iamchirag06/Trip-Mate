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
    public ResponseEntity<List<Preference>> getFilteredPreferences(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "budget", required = false) Double budget,
            @RequestParam(value = "days", required = false) Integer days) {
        List<Preference> preferences = service.getFilteredPreferences(type, budget, days);
        return ResponseEntity.ok(preferences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Preference> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Preference preference) {
        try {
            Preference saved = service.save(preference);
            return ResponseEntity.status(201).body(saved);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @Valid @RequestBody Preference preference) {
        try {
            return service.update(id, preference)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted preference with ID: " + id);
    }

    @GetMapping("/domestic")
    public ResponseEntity<List<Preference>> getDomesticTrips(
            @RequestParam(value = "budget", required = false) Double budget,
            @RequestParam(value = "days", required = false) Integer days) {
        List<Preference> preferences = service.getDomesticPreferencesWithFilters(budget, days);
        return preferences.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(preferences);
    }

    @GetMapping("/international")
    public ResponseEntity<List<Preference>> getInternationalTrips(
            @RequestParam(value = "budget", required = false) Double budget,
            @RequestParam(value = "days", required = false) Integer days) {
        List<Preference> preferences = service.getInternationalPreferencesWithFilters(budget, days);
        return preferences.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(preferences);
    }
}