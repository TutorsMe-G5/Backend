package com.tutorme.tutorme.rate.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfigurationR")
public class MappingConfiguration {

    @Bean
    public ReviewMapper reviewMapper(){
        return new ReviewMapper();
    }
}
