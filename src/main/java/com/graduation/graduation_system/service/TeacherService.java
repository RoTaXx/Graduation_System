package com.graduation.graduation_system.service;

import com.graduation.graduation_system.dto.Teacher.CreateTeacherDTO;
import com.graduation.graduation_system.dto.Teacher.TeacherDTO;
import com.graduation.graduation_system.dto.Teacher.UpdateTeacherDTO;

import java.util.List;

public interface TeacherService {
    List<TeacherDTO> getTeachers();

    TeacherDTO getTeacherById(long id);

    CreateTeacherDTO createTeacher(CreateTeacherDTO createTeacherDto);

    UpdateTeacherDTO updateTeacher(long id, UpdateTeacherDTO updateTeacherDto );

    void deleteTeacher(long id);
}
