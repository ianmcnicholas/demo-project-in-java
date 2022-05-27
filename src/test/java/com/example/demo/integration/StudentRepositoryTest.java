package com.example.demo.integration;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

@SpringBootTest
@ActiveProfiles(value = "test")
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void saveStudentTest() {

        Student student = new Student(
                1L, "test1", "test@test.com", LocalDate.of(1980, 2, 2));
        studentRepository.save(student);

        System.out.println(studentRepository.findAll());

//        assertNotNull(studentRepository.findById(1L));
//        assertThat(studentRepository.findAll().get(0).getName()).isEqualTo("test1");
//        assertThat(studentRepository.findAll().get(0).getEmail()).isEqualTo("test@test.com");
//        assertThat(studentRepository.findAll().get(0).getDob()).isEqualTo(LocalDate.of(1980, 2, 2));
    }

}
