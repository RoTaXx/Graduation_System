package com.graduation.graduation_system.data.repository;

import com.graduation.graduation_system.data.entity.Application;
import com.graduation.graduation_system.data.entity.Teacher;
import com.graduation.graduation_system.data.entity.enums.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByStatus(ApplicationStatus status);

    List<Application> findAllByThemeContainingOrderByTheme(String substringTheme);

    List<Application> findByTeacherAndStatus(Teacher teacher, ApplicationStatus status);
}
