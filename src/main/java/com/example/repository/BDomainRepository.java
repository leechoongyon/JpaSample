package com.example.repository;

import com.example.domain.BDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BDomainRepository extends JpaRepository<BDomain, Long> {
}
