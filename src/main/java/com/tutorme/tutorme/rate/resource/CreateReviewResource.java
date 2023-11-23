package com.tutorme.tutorme.rate.resource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tutorme.tutorme.user.domain.model.entities.Student;
import com.tutorme.tutorme.user.domain.model.entities.Teacher;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewResource {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String title;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private int rate;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 200)
    private String description;

    @JsonBackReference("reviewTeacherReference")
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    @JsonBackReference("reviewStudentReference")
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
}
