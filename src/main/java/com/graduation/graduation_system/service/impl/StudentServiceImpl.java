package com.graduation.graduation_system.service.impl;

import com.graduation.graduation_system.data.entity.Application;
import com.graduation.graduation_system.data.entity.Student;
import com.graduation.graduation_system.data.repository.StudentRepository;
import com.graduation.graduation_system.dto.Application.ApplicationDTO;
import com.graduation.graduation_system.dto.Student.CreateStudentDTO;
import com.graduation.graduation_system.dto.Student.StudentDTO;
import com.graduation.graduation_system.dto.Student.UpdateStudentDTO;
import com.graduation.graduation_system.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(long id) {
        return modelMapper.map(studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid student Id:" + id)), StudentDTO.class);
    }

    @Override
    public CreateStudentDTO createStudent(CreateStudentDTO createStudentDto) {
        return modelMapper.map(
                studentRepository.save(
                        modelMapper.map(createStudentDto, Student.class)), CreateStudentDTO.class);
    }

    @Override
    public UpdateStudentDTO updateStudent(long id, UpdateStudentDTO updateStudentDto) {
        Student student = modelMapper.map(getStudentById(id), Student.class);
        student.setFNumber(updateStudentDto.getFNumber());
        student.setFirstName(updateStudentDto.getFirstName());
        student.setLastName(updateStudentDto.getLastName());
        return modelMapper.map(studentRepository.save(student), UpdateStudentDTO.class);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    private StudentDTO convertToStudentDTO(Student student) { return modelMapper.map(student, StudentDTO.class); }
}
