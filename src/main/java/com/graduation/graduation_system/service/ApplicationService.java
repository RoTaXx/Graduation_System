package com.graduation.graduation_system.service;

import com.graduation.graduation_system.data.entity.Application;
import com.graduation.graduation_system.data.entity.Teacher;
import com.graduation.graduation_system.dto.Application.ApplicationDTO;
import com.graduation.graduation_system.dto.Application.CreateApplicationDTO;
import com.graduation.graduation_system.dto.Application.UpdateApplicationDTO;
import com.graduation.graduation_system.dto.Student.StudentDTO;
import com.graduation.graduation_system.dto.Teacher.TeacherDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface ApplicationService {
    List<ApplicationDTO> getApplications();
    ApplicationDTO getApplicationById(@Min(1) long id);
    CreateApplicationDTO createApplication(@Valid CreateApplicationDTO createApplicationDTO);
    UpdateApplicationDTO updateApplication(long id, UpdateApplicationDTO updateApplicationDTO);

    List<StudentDTO> getApplicationStudents();
    List<TeacherDTO> getApplicationTeachers();

    void deleteApplication(long id);

    List<ApplicationDTO> getApprovedApplications();

    List<ApplicationDTO> findAllByThemeContainingOrderByTheme(String substringTheme);

    List<ApplicationDTO> getApprovedApplicationsForTeacher(Teacher teacher);
}
