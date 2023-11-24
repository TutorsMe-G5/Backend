package com.tutorme.tutorme.rate.resource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tutorme.tutorme.user.domain.model.entities.Student;
import com.tutorme.tutorme.user.domain.model.entities.Teacher;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResource {
    private String title;
    private int rate;
    private String description;
    //private String stuPhoto;
    @JsonBackReference("reviewTeacherReference")
    private Teacher teacher;
    @JsonBackReference("reviewStudentReference")
    private Student student;
}
