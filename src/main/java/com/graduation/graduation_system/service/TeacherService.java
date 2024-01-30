package com.graduation.graduation_system.service;

import com.graduation.graduation_system.dto.Teacher.CreateTeacherDTO;
import com.graduation.graduation_system.dto.Teacher.TeacherDTO;
import com.graduation.graduation_system.dto.Teacher.UpdateTeacherDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface TeacherService {
    List<TeacherDTO> getTeachers();

    TeacherDTO getTeacherById(@Min(1) long id);

    CreateTeacherDTO createTeacher(@Valid CreateTeacherDTO createTeacherDto);

    UpdateTeacherDTO updateTeacher(long id, UpdateTeacherDTO updateTeacherDto );

    void deleteTeacher(long id);
}
