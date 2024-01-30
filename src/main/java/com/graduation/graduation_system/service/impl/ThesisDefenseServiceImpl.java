package com.graduation.graduation_system.service.impl;

import com.graduation.graduation_system.data.entity.ThesisDefense;
import com.graduation.graduation_system.data.entity.ThesisDefenseInfo;
import com.graduation.graduation_system.data.repository.ThesisDefenseRepository;
import com.graduation.graduation_system.dto.ThesisDefense.ThesisDefenseDTO;
import com.graduation.graduation_system.dto.ThesisDefense.ThesisDefenseInfoDTO;
import com.graduation.graduation_system.service.ThesisDefenseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class ThesisDefenseServiceImpl implements ThesisDefenseService {

    private final ThesisDefenseRepository thesisDefenseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ThesisDefenseDTO> getAllThesisDefenses() {
        return thesisDefenseRepository.findAll().stream()
                .map(this::convertToThesisDefenseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ThesisDefenseDTO getThesisDefenseById(@Min(1) Long id) {
        ThesisDefense thesisDefense = thesisDefenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid ThesisDefense Id:" + id));
        return convertToThesisDefenseDTO(thesisDefense);
    }

    @Override
    public ThesisDefenseDTO createThesisDefense(@Valid ThesisDefenseDTO thesisDefenseDTO) {
        ThesisDefense thesisDefense = modelMapper.map(thesisDefenseDTO, ThesisDefense.class);
        ThesisDefense savedThesisDefense = thesisDefenseRepository.save(thesisDefense);
        return convertToThesisDefenseDTO(savedThesisDefense);
    }

    @Override
    public ThesisDefenseDTO updateThesisDefense(Long id, ThesisDefenseDTO thesisDefenseDTO) {
        return null;
    }

    @Override
    public void deleteThesisDefense(Long id) {
        thesisDefenseRepository.deleteById(id);
    }

    private ThesisDefenseDTO convertToThesisDefenseDTO(ThesisDefense thesisDefense) {
        return modelMapper.map(thesisDefense, ThesisDefenseDTO.class);
    }
}
