package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://localhost:3000",                    // React dev server
                                "https://5173-idx-full-app-1746337034808.cluster-iktsryn7xnhpexlu6255bftka4.cloudworkstations.dev/",
                                "https://5173-idx-full-app-1746337034808.cluster-iktsryn7xnhpexlu6255bftka4.cloudworkstations.dev/suggest" // React deployed frontend (update this!)
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}

