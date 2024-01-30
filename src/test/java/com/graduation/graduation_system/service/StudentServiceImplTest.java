package com.graduation.graduation_system.service;

import com.graduation.graduation_system.data.entity.Student;
import com.graduation.graduation_system.data.repository.StudentRepository;
import com.graduation.graduation_system.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;

    @BeforeEach
    public void init() {
        student = new Student();
        student.setId(1L);
        student.setFirstName("Ivan");
        student.setLastName("Georgiev");
        student.setFNumber("F123456");
        studentRepository.save(student);
    }

    @Test
    void getStudentById() {
        // given
        given(studentRepository.findById(1L))
                .willReturn(Optional.of(student));

        // when
        StudentDto studentDto =
                studentService.
                        getStudentById(student.getId());

        // then
        assertThat(studentDto.getId()).isEqualTo(student.getId());
    }
}
