package com.example.prestamos.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public GroupedOpenApi prestamosApi() {
        return GroupedOpenApi.builder()
                .group("prestamos-api")
                .pathsToMatch("/api/**")
                .build();
    }
}