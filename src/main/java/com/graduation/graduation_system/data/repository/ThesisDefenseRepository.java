package com.graduation.graduation_system.data.repository;

import com.graduation.graduation_system.data.entity.ThesisDefense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ThesisDefenseRepository extends JpaRepository<ThesisDefense, Long> {

}
