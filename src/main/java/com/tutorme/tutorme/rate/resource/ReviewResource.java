package com.tutorme.tutorme.rate.resource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tutorme.tutorme.user.domain.model.entities.Student;
import com.tutorme.tutorme.user.domain.model.entities.Teacher;
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
    //@JsonBackReference
    //private Teacher teacher;
    //@JsonBackReference
    //private Student student;
}
