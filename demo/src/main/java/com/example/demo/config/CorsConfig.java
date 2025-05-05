package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // You can restrict this to /api/** if needed
//                .allowedOrigins("https://5173-idx-full-app-1746337034808.cluster-iktsryn7xnhpexlu6255bftka4.cloudworkstations.dev/",
//                        "https://5173-idx-full-app-1746337034808.cluster-iktsryn7xnhpexlu6255bftka4.cloudworkstations.dev/suggest",
//                        "http://localhost:5173")// React dev server
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
