package com.example.demo.config;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoTemplate mongoTemplate() {
        String mongoUri = System.getenv("MONGO_URI"); // Load from environment variable
        return new MongoTemplate(MongoClients.create(mongoUri), "sample_mflix");
    }
}
