package com.graduation.graduation_system.web.api;

import com.graduation.graduation_system.dto.Student.CreateStudentDTO;
import com.graduation.graduation_system.dto.Student.StudentDTO;
import com.graduation.graduation_system.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {

    private final StudentService studentService;

    public StudentApiController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getStudents() { return studentService.getStudents();}

    @PostMapping
    public CreateStudentDTO createStudentDTO(@RequestBody CreateStudentDTO createStudentDTO){
        return this.studentService.createStudent(createStudentDTO);
    }
    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable long id) {return this.studentService.getStudentById(id);}
}
