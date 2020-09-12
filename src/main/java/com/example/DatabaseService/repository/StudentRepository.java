package com.example.DatabaseService.repository;

import com.example.DatabaseService.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<Student, String> {
}
