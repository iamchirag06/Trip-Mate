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

    // Basic CRUD operations
    public List<Preference> getAll() {
        return repo.findAll();
    }

    public Optional<Preference> getById(String id) {
        return repo.findById(id);
    }

    public Preference save(Preference pref) {
        if (pref.getNumberOfDays() == null || pref.getNumberOfDays() < 1) {
            throw new IllegalArgumentException("Number of days must be at least 1");
        }
        return repo.save(pref);
    }

    public Optional<Preference> update(String id, Preference updated) {
        if (updated.getNumberOfDays() == null || updated.getNumberOfDays() < 1) {
            throw new IllegalArgumentException("Number of days must be at least 1");
        }
        return repo.findById(id).map(existing -> {
            updated.setId(id);
            return repo.save(updated);
        });
    }

    public void delete(String id) {
        repo.deleteById(id);
    }

    // Domain-specific operations
    public List<Preference> getDomesticPreferences() {
        return repo.findByDestinationTypeIgnoreCase("domestic");
    }

    public List<Preference> getInternationalPreferences() {
        return repo.findByDestinationTypeIgnoreCase("international");
    }

    public List<Preference> getDomesticPreferencesWithFilters(Double budget, Integer days) {
        if (budget == null && days == null) {
            return getDomesticPreferences();
        }
        return repo.findByTypeAndBudgetAndDays("domestic", budget, days);
    }

    public List<Preference> getInternationalPreferencesWithFilters(Double budget, Integer days) {
        if (budget == null && days == null) {
            return getInternationalPreferences();
        }
        return repo.findByTypeAndBudgetAndDays("international", budget, days);
    }

    public List<Preference> getFilteredPreferences(String type, Double budget, Integer days) {
        if (type == null && budget == null && days == null) {
            return getAll();
        }
        if (type != null) {
            if ("domestic".equalsIgnoreCase(type)) {
                return getDomesticPreferencesWithFilters(budget, days);
            } else if ("international".equalsIgnoreCase(type)) {
                return getInternationalPreferencesWithFilters(budget, days);
            }
        }
        return repo.findAll().stream()
                .filter(pref -> type == null ||
                        (pref.getDestinationType() != null &&
                                pref.getDestinationType().equalsIgnoreCase(type)))
                .filter(pref -> budget == null ||
                        (pref.getBudget() <= budget))
                .filter(pref -> days == null ||
                        (pref.getNumberOfDays() != null &&
                                pref.getNumberOfDays() <= days))
                .toList();
    }
}