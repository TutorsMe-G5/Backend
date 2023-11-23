package com.tutorme.tutorme.user.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tutorme.tutorme.rate.domain.model.entities.Review;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeacherResource {

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
    private boolean notifications;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<Review> reviews;
}
