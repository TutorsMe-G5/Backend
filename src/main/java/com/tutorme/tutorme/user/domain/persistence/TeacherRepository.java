package com.tutorme.tutorme.user.domain.persistence;

import com.tutorme.tutorme.user.domain.model.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    //Optional<Teacher> findById(Integer id);

    boolean existsByFirstName(String name);

    Optional<Teacher> findByFirstName(String name);
    boolean existsByMailAndPassword(String mail, String password);

    Optional<Teacher> findByMailAndPassword(String mail, String password);
}
