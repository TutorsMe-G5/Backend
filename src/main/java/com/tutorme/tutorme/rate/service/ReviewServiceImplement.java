package com.tutorme.tutorme.rate.service;

import com.tutorme.tutorme.rate.domain.model.entities.Review;
import com.tutorme.tutorme.rate.domain.persistence.ReviewRepository;
import com.tutorme.tutorme.rate.domain.service.ReviewService;
import com.tutorme.tutorme.shared.exeption.FetchIdNotFoundException;
import com.tutorme.tutorme.shared.exeption.ResourceValidationException;
import com.tutorme.tutorme.user.domain.model.entities.Student;
import com.tutorme.tutorme.user.domain.model.entities.Teacher;
import com.tutorme.tutorme.user.domain.persistence.StudentRepository;
import com.tutorme.tutorme.user.domain.persistence.TeacherRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ReviewServiceImplement implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private Validator validator;

    @Transactional
    @Override
    public Review save(Review review, Integer tId, Integer sId) {
        if(teacherRepository.existsById(tId)){
            if (studentRepository.existsById(sId)){
                Set<ConstraintViolation<Review>> violations = validator.validate(review);
                if (violations.isEmpty()){
                    return reviewRepository.save(review);
                }
                throw new ResourceValidationException("Review", violations);
            }
            throw new FetchIdNotFoundException("Student", sId);
        }
        throw new FetchIdNotFoundException("Teacher", tId);

    }

    @Transactional
    @Override
    public Review update(Review review) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Review> fetchAll() {
        return reviewRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Review> fetchByRate(int rate) {
        return reviewRepository.findByRate(rate);
    }

    @Override
    public List<Review> fetchByTeacherId(Integer teacherId) {
        return reviewRepository.findByTeacherId(teacherId);
    }

    @Override
    public Review fetchById(Integer id) {
        if (reviewRepository.existsById(id)){
            return reviewRepository.findById(id).get();
        }
        throw new FetchIdNotFoundException("Review", id);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (reviewRepository.existsById(id)){
            reviewRepository.deleteById(id);
            if (reviewRepository.existsById(id)){
                return false;
            }
            return true;
        }
        throw new FetchIdNotFoundException("Review", id);
    }
}
