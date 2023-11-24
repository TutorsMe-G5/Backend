package com.tutorme.tutorme.rate.domain.service;

import com.tutorme.tutorme.rate.domain.model.entities.Review;

import java.util.List;

public interface ReviewService {
    Review save(Review review);
    Review update(Review review);
    List<Review> fetchAll();
    List<Review> fetchByRate(int rate);
    List<Review> fetchByTeacherId(Integer teacherId);
    Review fetchById (Integer id);
    boolean deleteById(Integer id);
}
