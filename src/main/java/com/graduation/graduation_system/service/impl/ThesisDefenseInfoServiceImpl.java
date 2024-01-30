package com.graduation.graduation_system.service.impl;

import com.graduation.graduation_system.data.entity.ThesisDefenseInfo;
import com.graduation.graduation_system.data.repository.ThesisDefenseInfoRepository;
import com.graduation.graduation_system.dto.ThesisDefense.ThesisDefenseInfoDTO;
import com.graduation.graduation_system.service.ThesisDefenseInfoService;
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
public class ThesisDefenseInfoServiceImpl implements ThesisDefenseInfoService {

    private final ThesisDefenseInfoRepository thesisDefenseInfoRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<ThesisDefenseInfoDTO> getAllThesisDefenseInfos() {
        List<ThesisDefenseInfo> thesisDefenseInfos = thesisDefenseInfoRepository.findAll();
        return thesisDefenseInfos.stream()
                .map(this::convertToThesisDefenseInfoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ThesisDefenseInfoDTO getThesisDefenseInfoById(@Min(1) Long id) {
        ThesisDefenseInfo thesisDefenseInfo = thesisDefenseInfoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid ThesisDefenseInfo Id:" + id));
        return convertToThesisDefenseInfoDTO(thesisDefenseInfo);
    }

    @Override
    public ThesisDefenseInfoDTO createThesisDefenseInfo(@Valid ThesisDefenseInfoDTO thesisDefenseInfoDTO) {
        ThesisDefenseInfo thesisDefenseInfo = modelMapper.map(thesisDefenseInfoDTO, ThesisDefenseInfo.class);
        ThesisDefenseInfo savedThesisDefenseInfo = thesisDefenseInfoRepository.save(thesisDefenseInfo);
        return convertToThesisDefenseInfoDTO(savedThesisDefenseInfo);
    }

    @Override
    public ThesisDefenseInfoDTO updateThesisDefenseInfo(Long id, ThesisDefenseInfoDTO thesisDefenseInfoDTO) {
        return null;
    }

    @Override
    public void deleteThesisDefenseInfo(Long id) {
        thesisDefenseInfoRepository.deleteById(id);
    }

    private ThesisDefenseInfoDTO convertToThesisDefenseInfoDTO(ThesisDefenseInfo thesisDefenseInfo) {
        return modelMapper.map(thesisDefenseInfo, ThesisDefenseInfoDTO.class);
    }
}
