package com.graduation.graduation_system.web.view.controller;

import com.graduation.graduation_system.dto.Student.CreateStudentDTO;
import com.graduation.graduation_system.dto.Student.StudentDTO;
import com.graduation.graduation_system.dto.Student.UpdateStudentDTO;
import com.graduation.graduation_system.exceptions.ApplicationNotFoundException;
import com.graduation.graduation_system.exceptions.StudentNotFoundException;
import com.graduation.graduation_system.exceptions.TeacherNotFoundException;
import com.graduation.graduation_system.service.StudentService;
import com.graduation.graduation_system.web.view.model.Student.CreateStudentViewModel;
import com.graduation.graduation_system.web.view.model.Student.StudentViewModel;
import com.graduation.graduation_system.web.view.model.Student.UpdateStudentViewModel;
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
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    private final ModelMapper modelMapper;

    @GetMapping
    private String getStudents(Model model) {
        final List<StudentViewModel> students =
                studentService.getStudents().stream()
                        .map(this::convertToStudentViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("students", students);
        return "/students/students";
    }

    @GetMapping("/create-student")
    public String showCreateStudentForm(Model model) {
        model.addAttribute("student", new CreateStudentViewModel());
        return "/students/create-student";
    }

    @PostMapping("/create")
    public String createStudent(@Valid @ModelAttribute("student") CreateStudentViewModel student,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/students/create-student";
        }
        studentService.createStudent(modelMapper.map(student, CreateStudentDTO.class));
        return "redirect:/students";
    }

    @GetMapping("/edit-student/{id}")
    public String showEditStudentForm(Model model, @PathVariable Long id) {
        model.addAttribute("student", modelMapper.map(studentService.getStudentById(id),
                UpdateStudentViewModel.class));
        return "/students/edit-student";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable long id, @Valid @ModelAttribute("student") UpdateStudentViewModel student,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/students/edit-student";
        }
        studentService.updateStudent(id, modelMapper.map(student, UpdateStudentDTO.class));
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    private StudentViewModel convertToStudentViewModel(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, StudentViewModel.class);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public String handleException(StudentNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/errors/student-errors";
    }
}
