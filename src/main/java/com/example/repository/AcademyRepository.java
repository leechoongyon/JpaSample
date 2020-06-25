package com.example.repository;

import com.example.model.Academy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyRepository extends JpaRepository<Academy, Long>, AcademyRepositoryCustom {
}