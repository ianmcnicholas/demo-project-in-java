package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(1L, "Mary", 32, "mary@mary.com", LocalDate.of(1989, 6, 22)));
    }
}
