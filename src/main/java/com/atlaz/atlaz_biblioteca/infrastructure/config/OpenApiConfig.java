package com.atlaz.atlaz_biblioteca.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    // configuração do swagger

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Atlaz Biblioteca API")
                        .version("1.0")
                        .description("API para Gestão de Empréstimos de Livros"));
    }
}
