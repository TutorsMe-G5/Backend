package com.tutorme.tutorme.user.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tutorme.tutorme.rate.domain.model.entities.Review;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name  = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="first_name", length = 50, nullable = false)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="last_name", length = 50, nullable = false)//Snake para columnas y tablas en general
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="password", length = 50, nullable = false)//Snake para columnas y tablas en general
    private String password;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="mail", length = 50, nullable = false)//Snake para columnas y tablas en general
    private String mail;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @NotNull
    @Column(name="notification", length = 50, nullable = false)//Snake para columnas y tablas en general
    private boolean notifications;

    @JsonManagedReference("reviewStudentReference")
    @OneToMany(mappedBy = "student")
    private List<Review> reviews;

}
