package com.atlaz.atlaz_biblioteca.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// essa configuração faz com que seja evitado o CORS, um erro de segurança que pode impedir as comunicações, a menos que a permissão seja explícita como abaixo

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        // libera acesso para todas as rotas da API (/books, /students, /loan, etc)
        registry.addMapping("/**")

                // endereço exato do vue.js do projeto (porta 5173)
                .allowedOrigins("http://localhost:5173")

                // os métodos que o vue.js pode usar
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")

                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
