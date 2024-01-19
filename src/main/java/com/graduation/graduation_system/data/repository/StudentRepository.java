package com.graduation.graduation_system.data.repository;

import com.graduation.graduation_system.data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
