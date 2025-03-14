package com.rafaelmachado.microservicea.config;

import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microservice A API")
                        .version("1.0")
                        .description("API do Microserviço A que se comunica com o Microserviço B")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}