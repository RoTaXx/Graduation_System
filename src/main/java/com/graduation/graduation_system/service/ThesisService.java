package com.graduation.graduation_system.service;

import com.graduation.graduation_system.dto.Thesis.CreateThesisDTO;
import com.graduation.graduation_system.dto.Thesis.ThesisDTO;
import com.graduation.graduation_system.dto.Thesis.UpdateThesisDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface ThesisService {
    List<ThesisDTO> getTheses();

    ThesisDTO getThesisById(@Min(1) long id);

    CreateThesisDTO createThesis(@Valid CreateThesisDTO createThesisDTO, long applicationId);

    UpdateThesisDTO updateThesis(long id, UpdateThesisDTO updateThesisDTO);

    void deleteThesis(long id);
}
