package com.graduation.graduation_system.data.repository;

import com.graduation.graduation_system.data.entity.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThesisRepository extends JpaRepository<Thesis, Long> {
    Thesis findById(long thesisId);
}
