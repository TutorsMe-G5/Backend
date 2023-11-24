package com.tutorme.tutorme.user.resource;

import com.tutorme.tutorme.rate.domain.model.entities.Review;
import lombok.*;

import java.util.List;

@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResource {
    private String firstName;
    private String lastName;
    private String password;
    private String mail;
    private String photo;
    private boolean notifications;
    //private List<Review> reviews;
}
