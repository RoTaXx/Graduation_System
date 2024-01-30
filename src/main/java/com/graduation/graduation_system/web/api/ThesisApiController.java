package com.graduation.graduation_system.web.api;

import com.graduation.graduation_system.dto.Thesis.CreateThesisDTO;
import com.graduation.graduation_system.dto.Thesis.ThesisDTO;
import com.graduation.graduation_system.dto.Thesis.UpdateThesisDTO;
import com.graduation.graduation_system.service.ThesisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theses")
public class ThesisApiController {
    private final ThesisService thesisService;

    public ThesisApiController(ThesisService thesisService) {
        this.thesisService = thesisService;
    }

    @GetMapping
    public List<ThesisDTO> getTheses() {
        return thesisService.getTheses();
    }

    @PostMapping("/{applicationId}")
    public CreateThesisDTO createThesis(@RequestBody CreateThesisDTO createThesisDTO, @PathVariable Long applicationId) {
        return thesisService.createThesis(createThesisDTO, applicationId);
    }

    @GetMapping("/{id}")
    public ThesisDTO getThesisById(@PathVariable Long id) {
        return thesisService.getThesisById(id);
    }

    @PutMapping("/{id}")
    public UpdateThesisDTO updateThesis(@PathVariable Long id, @RequestBody UpdateThesisDTO updateThesisDTO) {
        return thesisService.updateThesis(id, updateThesisDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteThesis(@PathVariable Long id) {
        thesisService.deleteThesis(id);
    }
}

