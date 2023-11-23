package com.tutorme.tutorme.shared.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenApi (
            @Value("${documentation.application.description}") String applicationDescription,
            @Value("${documentation.application.version}") String applicationVersion) {
        return new OpenAPI().info(new Info()
                .title("Schedule API v2")
                .version(applicationVersion)
                .description(applicationDescription)
                .termsOfService("https://www.upc.edu.pe/tos")
                .license(new License().name("Apache 2.0 License").url("https://www.upc.edu.pe/license"))
                .contact(new Contact()
                        .url("https://github.com/upc-is-si729/daos-schedule-v2-spring")
                        .name("UPC-si729"))
        );
    }
}
