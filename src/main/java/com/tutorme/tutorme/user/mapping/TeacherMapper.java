package com.tutorme.tutorme.user.mapping;

import com.tutorme.tutorme.shared.mapping.EnhancedModelMapper;
import com.tutorme.tutorme.user.domain.model.entities.Teacher;
import com.tutorme.tutorme.user.resource.CreateTeacherResource;
import com.tutorme.tutorme.user.resource.TeacherResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class TeacherMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;
    public Teacher toEntity(CreateTeacherResource resource){
        return this.mapper.map(resource, Teacher.class);
    }

    public TeacherResource toResource(Teacher teacher){
        return this.mapper.map(teacher, TeacherResource.class);
    }
}
