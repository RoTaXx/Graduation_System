package com.graduation.graduation_system.web.view.controller;

import com.graduation.graduation_system.dto.Teacher.CreateTeacherDTO;
import com.graduation.graduation_system.dto.Teacher.TeacherDTO;
import com.graduation.graduation_system.dto.Teacher.UpdateTeacherDTO;
import com.graduation.graduation_system.service.TeacherService;
import com.graduation.graduation_system.web.view.model.Teacher.CreateTeacherViewModel;
import com.graduation.graduation_system.web.view.model.Teacher.TeacherViewModel;
import com.graduation.graduation_system.web.view.model.Teacher.UpdateTeacherViewModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    private final ModelMapper modelMapper;

    @GetMapping
    private String getTeachers(Model model) {
        final List<TeacherViewModel> teachers =
                teacherService.getTeachers().stream()
                        .map(this::convertToTeacherViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("teachers", teachers);
        return "/teachers/teachers";
    }

    @GetMapping("/create-teacher")
    public String showCreateTeacherForm(Model model) {
        model.addAttribute("teacher", new CreateTeacherViewModel());
        return "/teachers/create-teacher";
    }

    @PostMapping("/create")
    public String createTeacher(@Valid @ModelAttribute("teacher") CreateTeacherViewModel teacher,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/teachers/create-teacher";
        }
        teacherService.createTeacher(modelMapper.map(teacher, CreateTeacherDTO.class));
        return "redirect:/teachers";
    }

    @GetMapping("/edit-teacher/{id}")
    public String showEditTeacherForm(Model model, @PathVariable Long id) {
        model.addAttribute("teacher", modelMapper.map(teacherService.getTeacherById(id),
                UpdateTeacherViewModel.class));
        return "/teachers/edit-teacher";
    }

    @PostMapping("/update/{id}")
    public String updateTeacher(@PathVariable long id, @Valid @ModelAttribute("teacher") UpdateTeacherViewModel teacher,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/teachers/edit-teacher";
        }
        teacherService.updateTeacher(id, modelMapper.map(teacher, UpdateTeacherDTO.class));
        return "redirect:/teachers";
    }


    private TeacherViewModel convertToTeacherViewModel(TeacherDTO teacherDTO) {
        return modelMapper.map(teacherDTO, TeacherViewModel.class);
    }
}
