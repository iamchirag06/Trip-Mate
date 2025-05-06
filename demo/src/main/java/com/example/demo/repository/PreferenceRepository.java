package com.example.demo.repository;

import com.example.demo.model.Preference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PreferenceRepository extends MongoRepository<Preference, String> {

    List<Preference> findByDestinationTypeIgnoreCase(String destinationType);

    @Query("{$and: ["
            + "{'destinationType': {$regex: ?0, $options: 'i'}}, "
            + "{'budget': {$lte: ?1}}, "
            + "{'numberOfDays': {$lte: ?2}}, "
            + "{'numberOfDays': {$ne: null}}"
            + "]}")
    List<Preference> findByTypeAndBudgetAndDays(String destinationType, Double budget, Integer days);

    @Query("{$and: ["
            + "{'destinationType': {$regex: ?0, $options: 'i'}}, "
            + "{'budget': {$lte: ?1}}, "
            + "{'numberOfDays': {$ne: null}}"
            + "]}")
    List<Preference> findByDestinationTypeIgnoreCaseAndBudgetLessThanEqual(String destinationType, Double budget);

    @Query("{$and: ["
            + "{'destinationType': {$regex: ?0, $options: 'i'}}, "
            + "{'numberOfDays': {$lte: ?1}}, "
            + "{'numberOfDays': {$ne: null}}"
            + "]}")
    List<Preference> findByDestinationTypeIgnoreCaseAndNumberOfDaysLessThanEqual(String destinationType, Integer days);
}