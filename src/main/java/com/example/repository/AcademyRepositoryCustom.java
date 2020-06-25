package com.example.repository;

import com.example.model.Academy;

import java.util.List;

public interface AcademyRepositoryCustom {
    List<Academy> findByName(String name);
}