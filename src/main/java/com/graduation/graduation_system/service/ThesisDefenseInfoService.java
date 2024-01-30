package com.graduation.graduation_system.service;

import com.graduation.graduation_system.dto.ThesisDefense.ThesisDefenseInfoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface ThesisDefenseInfoService {
    List<ThesisDefenseInfoDTO> getAllThesisDefenseInfos();
    ThesisDefenseInfoDTO getThesisDefenseInfoById(@Min(1) Long id);
    ThesisDefenseInfoDTO createThesisDefenseInfo(@Valid ThesisDefenseInfoDTO thesisDefenseInfoDTO);
    ThesisDefenseInfoDTO updateThesisDefenseInfo(Long id, ThesisDefenseInfoDTO thesisDefenseInfoDTO);
    void deleteThesisDefenseInfo(Long id);
}
