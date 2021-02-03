package com.example.repository;

import com.example.domain.ADomain;
import com.example.model.Academy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ADomainRepository extends JpaRepository<ADomain, Long> {
}
