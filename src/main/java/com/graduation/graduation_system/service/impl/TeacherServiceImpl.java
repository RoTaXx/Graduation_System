package com.graduation.graduation_system.service.impl;

import com.graduation.graduation_system.data.entity.Teacher;
import com.graduation.graduation_system.data.repository.TeacherRepository;
import com.graduation.graduation_system.dto.Application.ApplicationDTO;
import com.graduation.graduation_system.dto.Teacher.CreateTeacherDTO;
import com.graduation.graduation_system.dto.Teacher.TeacherDTO;
import com.graduation.graduation_system.dto.Teacher.UpdateTeacherDTO;
import com.graduation.graduation_system.service.TeacherService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<TeacherDTO> getTeachers() {
        return teacherRepository.findAll().stream()
                .map(this::convertToTeacherDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO getTeacherById(long id) {
        return modelMapper.map(teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid teacher Id:" + id)), TeacherDTO.class);
    }

    @Override
    public CreateTeacherDTO createTeacher(CreateTeacherDTO createTeacherDto) {
        return modelMapper
                .map(teacherRepository.save(modelMapper.map(createTeacherDto, Teacher.class)), CreateTeacherDTO.class);
    }

    @Override
    public UpdateTeacherDTO updateTeacher(long id, UpdateTeacherDTO updateTeacherDto) {
        Teacher teacher = modelMapper.map(getTeacherById(id), Teacher.class);
        teacher.setFirstName(updateTeacherDto.getFirstName());
        teacher.setLastName(updateTeacherDto.getLastName());
        teacher.setPosition(updateTeacherDto.getPosition());
        return modelMapper.map(teacherRepository.save(teacher), UpdateTeacherDTO.class);
    }

    @Override
    public void deleteTeacher(long id) {
        teacherRepository.deleteById(id);
    }

    private TeacherDTO convertToTeacherDTO(Teacher teacher) {
        return modelMapper.map(teacher, TeacherDTO.class);
    }
}
