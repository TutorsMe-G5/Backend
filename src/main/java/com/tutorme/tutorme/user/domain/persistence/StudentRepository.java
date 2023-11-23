package com.tutorme.tutorme.user.domain.persistence;

import com.tutorme.tutorme.user.domain.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    boolean existsByFirstName(String name);

    Optional<Student> findByFirstName(String name);
}
