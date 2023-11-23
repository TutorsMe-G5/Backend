package com.tutorme.tutorme.user.domain.service;

import com.tutorme.tutorme.user.domain.model.entities.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    Student update(Student student);
    List<Student> fetchAll();
    Student findByName(String name);
    Student fetchById(Integer id);
    boolean deleteById(Integer id);
}
