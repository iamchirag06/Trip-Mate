package com.example.demo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "sample")
public class Preference {

    @Id
    private String id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Destination type is required")
    private String destinationType;

    @Min(value = 0, message = "Budget must be positive")
    private double budget;

    private String healthCondition;

    @NotNull(message = "Number of days is required")
    @Min(value = 1, message = "Trip must be at least 1 day")
    @Field("numberOfDays")
    private Integer numberOfDays;

    private String rating;
    private String image_url;
    private String photographer;
    private String alt_text;

    public Preference() {}

    public Preference(String name, String location, String destinationType,
                      double budget, String healthCondition, Integer numberOfDays,
                      String rating, String image_url, String photographer, String alt_text) {
        this.name = name;
        this.location = location;
        this.destinationType = destinationType;
        this.budget = budget;
        this.healthCondition = healthCondition;
        this.numberOfDays = numberOfDays;
        this.rating = rating;
        this.image_url = image_url;
        this.photographer = photographer;
        this.alt_text = alt_text;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDestinationType() { return destinationType; }
    public void setDestinationType(String destinationType) { this.destinationType = destinationType; }

    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }

    public String getHealthCondition() { return healthCondition; }
    public void setHealthCondition(String healthCondition) { this.healthCondition = healthCondition; }

    public Integer getNumberOfDays() { return numberOfDays; }
    public void setNumberOfDays(Integer numberOfDays) { this.numberOfDays = numberOfDays; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }

    public String getImage_url() { return image_url; }
    public void setImage_url(String image_url) { this.image_url = image_url; }

    public String getPhotographer() { return photographer; }
    public void setPhotographer(String photographer) { this.photographer = photographer; }

    public String getAlt_text() { return alt_text; }
    public void setAlt_text(String alt_text) { this.alt_text = alt_text; }
}
