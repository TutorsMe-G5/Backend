package com.tutorme.tutorme.user.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tutorme.tutorme.rate.domain.model.entities.Review;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentResource {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String password;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String mail;

    @NotNull
    @Size(min = 2, max = 1000)
    @Column(name="photo", nullable = false)
    private String photo;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @NotNull
    private boolean notifications;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Review> reviews;
}
