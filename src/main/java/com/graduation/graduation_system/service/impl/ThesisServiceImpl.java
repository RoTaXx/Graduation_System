package com.graduation.graduation_system.service.impl;

import com.graduation.graduation_system.data.entity.Application;
import com.graduation.graduation_system.data.entity.Thesis;
import com.graduation.graduation_system.data.entity.enums.ApplicationStatus;
import com.graduation.graduation_system.data.repository.ApplicationRepository;
import com.graduation.graduation_system.data.repository.ThesisRepository;
import com.graduation.graduation_system.dto.Thesis.CreateThesisDTO;
import com.graduation.graduation_system.dto.Thesis.ThesisDTO;
import com.graduation.graduation_system.dto.Thesis.UpdateThesisDTO;
import com.graduation.graduation_system.exceptions.ApplicationNotFoundException;
import com.graduation.graduation_system.exceptions.ThesisNotFoundException;
import com.graduation.graduation_system.service.ThesisService;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@AllArgsConstructor
@Validated
public class ThesisServiceImpl implements ThesisService {

    private final ModelMapper modelMapper;

    private final ApplicationRepository applicationRepository;

    private final ThesisRepository thesisRepository;

    @Override
    public List<ThesisDTO> getTheses() {
        return thesisRepository.findAll().stream()
                .map(this::convertToThesisDto)
                .collect(Collectors.toList());
    }

    @Override
    public ThesisDTO getThesisById(@Min(1) long id) {
        return modelMapper.map(thesisRepository.findById(id), ThesisDTO.class);
    }

    @Override
    public CreateThesisDTO createThesis(@Validated CreateThesisDTO createThesisDto, long applicationId) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new ApplicationNotFoundException("Invalid Application Id:" + applicationId));


        if (application.getStatus() == ApplicationStatus.APPROVED) {
            Thesis thesis = modelMapper.map(createThesisDto, Thesis.class);
            thesis.setApplication(application);
            return modelMapper.map(thesisRepository.save(thesis), CreateThesisDTO.class);
        } else {
            throw new RuntimeException("The application is not approved. Cannot create a thesis.");
        }
    }

        @Override
    public UpdateThesisDTO updateThesis(long id, UpdateThesisDTO updateThesisDTO) {
            try {
                Thesis thesis = modelMapper.map(getThesisById(id), Thesis.class);
                thesis.setTitle(updateThesisDTO.getTitle());
                thesis.setText(updateThesisDTO.getText());
                thesis.setPublicationDate(updateThesisDTO.getPublicationDate());

                return modelMapper.map(thesisRepository.save(thesis), UpdateThesisDTO.class);
            } catch (ThesisNotFoundException e) {
                throw e;
            } catch (Exception e) {
                throw new RuntimeException("An error occurred while updating the thesis", e);
            }
    }

    @Override
    public void deleteThesis(long id) {

    }

    private ThesisDTO convertToThesisDto(Thesis thesis) {
        return modelMapper.map(thesis, ThesisDTO.class);
    }
}


