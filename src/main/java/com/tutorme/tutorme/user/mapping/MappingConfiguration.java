package com.tutorme.tutorme.user.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TeacherMapper teacherMapper(){
        return new TeacherMapper();
    }

    @Bean
    public StudentMapper studentMapper(){
        return new StudentMapper();
    }
}
