package com.graduation.graduation_system.data.repository;

import com.graduation.graduation_system.data.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
