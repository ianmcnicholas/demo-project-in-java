package com.example.demo.config;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student ian = new Student(
                    "ian", "ian@example.com", LocalDate.of(1989, 1, 1));
            Student jeff = new Student(
                    "jeff", "jeff@example.com", LocalDate.of(1990, 10, 10));
            Student hugh = new Student(
                    "hugh", "hugh@example.com", LocalDate.of(1985, 2, 2));

            studentRepository.saveAll(
                    List.of(ian, jeff, hugh)
            );
        };

    }

}
