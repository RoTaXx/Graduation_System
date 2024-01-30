package com.graduation.graduation_system.service;

import com.graduation.graduation_system.dto.ThesisDefense.ThesisDefenseDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface ThesisDefenseService {
    List<ThesisDefenseDTO> getAllThesisDefenses();
    ThesisDefenseDTO getThesisDefenseById(@Min(1) Long id);
    ThesisDefenseDTO createThesisDefense(@Valid ThesisDefenseDTO thesisDefenseDTO);
    ThesisDefenseDTO updateThesisDefense(Long id, ThesisDefenseDTO thesisDefenseDTO);
    void deleteThesisDefense(Long id);
}
