package com.tutorme.tutorme.user.service;

import com.tutorme.tutorme.shared.exeption.FetchIdNotFoundException;
import com.tutorme.tutorme.shared.exeption.FetchNotFoundException;
import com.tutorme.tutorme.shared.exeption.ResourceValidationException;
import com.tutorme.tutorme.user.domain.model.entities.Teacher;
import com.tutorme.tutorme.user.domain.persistence.TeacherRepository;
import com.tutorme.tutorme.user.domain.service.TeacherService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class TeacherServiceImplement implements TeacherService {

    private final TeacherRepository teacherRepository;
    private Validator validator;

    @Transactional
    @Override
    public Teacher save(Teacher teacher) {
        Set<ConstraintViolation<Teacher>> violations = validator.validate(teacher);
        if(violations.isEmpty()){
            return teacherRepository.save(teacher);
        }
        throw new ResourceValidationException("Teacher", violations);
    }

    @Transactional
    @Override
    public Teacher update(Teacher teacher) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Teacher> fetchAll() {
        return teacherRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Teacher findByName(String name){
        if (teacherRepository.existsByFirstName(name)){
            return teacherRepository.findByFirstName(name).orElseThrow();
        }
        throw new FetchNotFoundException("Teacher", "name", name);
    }

    @Transactional(readOnly = true)
    @Override
    public Teacher fetchById(Integer id) {
        if(teacherRepository.existsById(id)){
            return teacherRepository.findById(id).get();
        }
        throw new FetchIdNotFoundException("Teacher", id);
    }

    @Override
    public boolean deleteById(Integer id) {
        if(teacherRepository.existsById(id)){
            teacherRepository.deleteById(id);
            if (teacherRepository.existsById(id))
                return false;
            return true;
        }
        throw new FetchIdNotFoundException("Teacher", id);
    }
}
