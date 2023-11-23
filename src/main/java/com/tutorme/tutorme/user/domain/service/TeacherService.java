package com.tutorme.tutorme.user.domain.service;

import com.tutorme.tutorme.user.domain.model.entities.Teacher;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TeacherService {
    Teacher save(Teacher teacher);
    Teacher update(Teacher teacher);
    List<Teacher> fetchAll();

    Teacher findByName(String name);

    Teacher fetchById(Integer id);
    boolean deleteById(Integer id);
}
