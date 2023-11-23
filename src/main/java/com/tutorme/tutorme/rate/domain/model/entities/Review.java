package com.tutorme.tutorme.rate.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tutorme.tutorme.user.domain.model.entities.Student;
import com.tutorme.tutorme.user.domain.model.entities.Teacher;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name  = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="title", length = 50, nullable = false)
    private String title;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "rate", columnDefinition = "smallint", nullable = false)
    private int rate;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 200)
    @Column(name="description", length = 200, nullable = false)//Snake para columnas y tablas en general
    private String description;

    @JsonBackReference("reviewTeacherReference")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @JsonBackReference("reviewStudentReference")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
}
