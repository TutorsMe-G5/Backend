package com.tutorme.tutorme.rate.mapping;

import com.tutorme.tutorme.rate.domain.model.entities.Review;
import com.tutorme.tutorme.rate.resource.CreateReviewResource;
import com.tutorme.tutorme.rate.resource.ReviewResource;
import com.tutorme.tutorme.shared.mapping.EnhancedModelMapper;
import com.tutorme.tutorme.user.domain.model.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import java.io.Serializable;
import java.util.List;

public class ReviewMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Review toEntity (CreateReviewResource resource){
        return this.mapper.map(resource, Review.class);
    }

    public ReviewResource toResource(Review review){
        return this.mapper.map(review, ReviewResource.class);
    }

}
