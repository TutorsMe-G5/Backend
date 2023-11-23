package com.tutorme.tutorme.user.mapping;

import com.tutorme.tutorme.shared.mapping.EnhancedModelMapper;
import com.tutorme.tutorme.user.domain.model.entities.Student;
import com.tutorme.tutorme.user.resource.CreateStudentResource;
import com.tutorme.tutorme.user.resource.StudentResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class StudentMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public Student toEntity(CreateStudentResource resource){
        return this.mapper.map(resource, Student.class);
    }
    public StudentResource toResource(Student student){
        return this.mapper.map(student, StudentResource.class);
    }
}
