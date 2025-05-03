package com.example.demo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Value("${MONGO_URI}")
    private String mongoUri;

    @Value("${MONGO_DATABASE}")
    private String databaseName;

    @Bean
    public MongoTemplate mongoTemplate() {
        // Create MongoClient from URI
        MongoClient mongoClient = MongoClients.create(mongoUri);

        // Create and return MongoTemplate with the MongoClient and database name
        return new MongoTemplate(mongoClient, databaseName);
    }
}
