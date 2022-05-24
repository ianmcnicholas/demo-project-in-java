package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
//    ^^^^^ Object to work with is a student, and the id type is a Long

    Optional<Student> findAllByEmail(String email);

}
