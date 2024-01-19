package com.graduation.graduation_system.web.api;

import com.graduation.graduation_system.dto.Application.ApplicationDTO;
import com.graduation.graduation_system.dto.Application.CreateApplicationDTO;
import com.graduation.graduation_system.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationApiController {

    private final ApplicationService applicationService;

    public ApplicationApiController(ApplicationService applicationService) {
        this.applicationService = applicationService;
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
}
