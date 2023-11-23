package com.tutorme.tutorme.user.service;

import com.tutorme.tutorme.shared.exeption.FetchIdNotFoundException;
import com.tutorme.tutorme.shared.exeption.FetchNotFoundException;
import com.tutorme.tutorme.shared.exeption.ResourceValidationException;
import com.tutorme.tutorme.user.domain.model.entities.Student;
import com.tutorme.tutorme.user.domain.persistence.StudentRepository;
import com.tutorme.tutorme.user.domain.service.StudentService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class StudentServiceImplement implements StudentService {

    private final StudentRepository studentRepository;
    private Validator validator;

    @Transactional
    @Override
    public Student save(Student student) {
        Set<ConstraintViolation<Student>> violations = validator.validate(student);
        if (violations.isEmpty()){
            return studentRepository.save(student);
        }
        throw new ResourceValidationException("Student", violations);
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Student> fetchAll() {
        return studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Student findByName(String name) {
        if(studentRepository.existsByFirstName(name)){
            return studentRepository.findByFirstName(name).orElseThrow();
        }
        throw new FetchNotFoundException("Student", "name", name);
    }

    @Override
    public Student fetchById(Integer id) {
        if(studentRepository.existsById(id)){
            return studentRepository.findById(id).get();
        }
        throw new FetchIdNotFoundException("Student", id);
    }

    @Override
    public boolean deleteById(Integer id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            if(studentRepository.existsById(id)){
                return false;
            }
            return true;
        }
        throw new FetchIdNotFoundException("Student", id);
    }
}
