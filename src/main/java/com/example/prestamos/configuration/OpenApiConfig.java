package com.example.prestamos.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Préstamos de Herramientas")
                        .version("1.0.0")
                        .description("API REST para registrar herramientas, realizar préstamos "
                                + "y consultar los movimientos del laboratorio de tecnología.")
                        .contact(new Contact()
                                .name("Nicolás Esteban Flórez González")
                                .email("nestebaflorez@ucundinamarca.edu.co")));
    }
}