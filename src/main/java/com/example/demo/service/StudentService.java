package com.example.demo.service;

import com.example.demo.exception.EmailDuplicationException;
import com.example.demo.exception.NoStudentFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) throws EmailDuplicationException {

        if (studentRepository.findAllByEmail(student.getEmail()).isEmpty()) {
            studentRepository.save(student);
        } else throw new EmailDuplicationException("The email address " + student.getEmail() + " is already taken");
    }

    public void deleteStudent(Long studentId) throws NoStudentFoundException {

        if (studentRepository.findById(studentId).isEmpty()) {
            throw new NoStudentFoundException("Could not find student with id: " + studentId);
        } else studentRepository.deleteById(studentId);
    }

    @Transactional
    // ^^^^^ allows database to update itself through the method.
    public void updateStudent(Long studentId, String name ,String email)
            throws NoStudentFoundException, EmailDuplicationException {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoStudentFoundException("Could not find student with id: " + studentId));

        if (email != null) {
            if (studentRepository.findAllByEmail(email).isPresent()) {
                throw new EmailDuplicationException("The email address " + student.getEmail() + " is already taken");
            } else student.setEmail(email);
        }

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        // ^^^^^ Basic validation / verification that could be increased e.g. email format, exceptions etc.
    }


}
