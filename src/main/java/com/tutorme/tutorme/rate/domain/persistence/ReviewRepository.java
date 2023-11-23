package com.tutorme.tutorme.rate.domain.persistence;

import com.tutorme.tutorme.rate.domain.model.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByRate(int rate);
}
