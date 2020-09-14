package com.example.DatabaseService.repository;

import com.example.DatabaseService.entity.Admin;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<Admin, String> {
}
