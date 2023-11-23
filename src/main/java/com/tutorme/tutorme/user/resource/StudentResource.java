package com.tutorme.tutorme.user.resource;

import com.tutorme.tutorme.rate.domain.model.entities.Review;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class StudentResource {
    private String firstName;
    private String lastName;
    private String password;
    private String mail;
    private Date birthDate;
    private boolean notifications;
    //private List<Review> reviews;
}
