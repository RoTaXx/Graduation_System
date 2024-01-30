package com.graduation.graduation_system.web.view.controller;

import com.graduation.graduation_system.data.entity.enums.ApplicationStatus;
import com.graduation.graduation_system.dto.Application.ApplicationDTO;
import com.graduation.graduation_system.dto.Application.CreateApplicationDTO;
import com.graduation.graduation_system.dto.Application.UpdateApplicationDTO;
import com.graduation.graduation_system.exceptions.ApplicationNotFoundException;
import com.graduation.graduation_system.exceptions.StudentNotFoundException;
import com.graduation.graduation_system.exceptions.TeacherNotFoundException;
import com.graduation.graduation_system.service.ApplicationService;
import com.graduation.graduation_system.web.view.model.Application.ApplicationViewModel;
import com.graduation.graduation_system.web.view.model.Application.CreateApplicationViewModel;
import com.graduation.graduation_system.web.view.model.Application.UpdateApplicationViewModel;
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
@RequestMapping("/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    private final ModelMapper modelMapper;

    @GetMapping
    private String getApplications(Model model) {
        final List<ApplicationViewModel> applications =
                applicationService.getApplications().stream()
                        .map(this::convertToApplicationViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("applications", applications);
        return "/applications/applications";
    }

    @GetMapping("/create-application")
    public String showCreateApplicationForm(Model model) {
        model.addAttribute("application", new CreateApplicationViewModel());
        model.addAttribute("status", ApplicationStatus.values());
        model.addAttribute("students", applicationService.getApplicationStudents());
        model.addAttribute("teachers", applicationService.getApplicationTeachers());
        return "/applications/create-application";
    }

    @PostMapping("/create")
    public String createApplication(@Valid @ModelAttribute("application") CreateApplicationViewModel application,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/applications/create-application";
        }
        applicationService.createApplication(modelMapper.map(application, CreateApplicationDTO.class));
        return "redirect:/applications";
    }

    @GetMapping("/edit-application/{id}")
    public String showEditApplicationForm(Model model, @PathVariable Long id) {
        model.addAttribute("application", modelMapper.map(applicationService.getApplicationById(id),
                UpdateApplicationViewModel.class));
        return "/applications/edit-application";
    }

    @PostMapping("/update/{id}")
    public String updateApplication(@PathVariable long id, @Valid @ModelAttribute("application") UpdateApplicationViewModel application,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/applications/edit-application";
        }
        applicationService.updateApplication(id, modelMapper.map(application, UpdateApplicationDTO.class));
        return "redirect:/applications";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable long id) {
        applicationService.deleteApplication(id);
        return "redirect:/applications";
    }

    private ApplicationViewModel convertToApplicationViewModel(ApplicationDTO applicationDTO) {
        return modelMapper.map(applicationDTO, ApplicationViewModel.class);
    }

    @ExceptionHandler({ApplicationNotFoundException.class, TeacherNotFoundException.class, StudentNotFoundException.class})
    public String handleException(ApplicationNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/errors/application-errors";
    }
}
