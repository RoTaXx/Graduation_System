package com.graduation.graduation_system.web.api;

import com.graduation.graduation_system.dto.Application.ApplicationDTO;
import com.graduation.graduation_system.dto.Teacher.CreateTeacherDTO;
import com.graduation.graduation_system.dto.Teacher.TeacherDTO;
import com.graduation.graduation_system.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherApiController {
    private final TeacherService teacherService;

    public TeacherApiController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<TeacherDTO> getTeachers(){return teacherService.getTeachers();}

    @PostMapping
    public CreateTeacherDTO createTeacher(@RequestBody CreateTeacherDTO createTeacherDTO){
        return this.teacherService.createTeacher(createTeacherDTO);
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeacherById(@PathVariable long id) {return this.teacherService.getTeacherById(id);}
}
