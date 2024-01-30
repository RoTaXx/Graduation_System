package com.graduation.graduation_system.service;

import com.graduation.graduation_system.dto.Student.CreateStudentDTO;
import com.graduation.graduation_system.dto.Student.StudentDTO;
import com.graduation.graduation_system.dto.Student.UpdateStudentDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getStudents();

    StudentDTO getStudentById(@Min(1) long id);

    CreateStudentDTO createStudent(@Valid CreateStudentDTO createStudentDTO);

    UpdateStudentDTO updateStudent(long id, UpdateStudentDTO updateStudentDTO);

    void deleteStudent(long id);
}
