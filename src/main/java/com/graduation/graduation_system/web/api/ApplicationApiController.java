package com.graduation.graduation_system.web.api;

import com.graduation.graduation_system.data.entity.Application;
import com.graduation.graduation_system.data.entity.Teacher;
import com.graduation.graduation_system.dto.Application.ApplicationDTO;
import com.graduation.graduation_system.dto.Application.CreateApplicationDTO;
import com.graduation.graduation_system.dto.Teacher.TeacherDTO;
import com.graduation.graduation_system.service.ApplicationService;
import com.graduation.graduation_system.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationApiController {

    private final ApplicationService applicationService;

    private final TeacherService teacherService;

    public ApplicationApiController(ApplicationService applicationService, TeacherService teacherService) {
        this.applicationService = applicationService;
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<ApplicationDTO> getApplications(){
        return applicationService.getApplications();
    }

    @PostMapping
    public CreateApplicationDTO createApplication(@RequestBody CreateApplicationDTO createApplicationDTO){
        return this.applicationService.createApplication(createApplicationDTO);
    }

    @GetMapping("/{id}")
    public ApplicationDTO getApplicationById(@PathVariable long id) {return this.applicationService.getApplicationById(id);}

    @GetMapping("/approved")
    public List<ApplicationDTO> getApprovedApplications() {
        return this.applicationService.getApprovedApplications();
    }

    /*@GetMapping("/approved/{teacherId}")
    public List<ApplicationDTO> getApprovedApplicationsForTeacher(@PathVariable Long teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return applicationService.getApprovedApplicationsForTeacher(teacher);
    }*/

    @GetMapping("/contain/{substringTheme}")
    public List<ApplicationDTO> getAllContainingSubstringInTheme(@PathVariable String substringTheme) {
        return this.applicationService.findAllByThemeContainingOrderByTheme(substringTheme);
    }
}


