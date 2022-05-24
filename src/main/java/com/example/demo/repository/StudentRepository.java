package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface StudentRepository extends JpaRepository<Id, Long> {
}
