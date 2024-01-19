package com.graduation.graduation_system.service.impl;

import com.graduation.graduation_system.data.entity.Application;
import com.graduation.graduation_system.data.repository.ApplicationRepository;
import com.graduation.graduation_system.dto.Application.ApplicationDTO;
import com.graduation.graduation_system.dto.Application.CreateApplicationDTO;
import com.graduation.graduation_system.dto.Application.UpdateApplicationDTO;
import com.graduation.graduation_system.dto.Student.StudentDTO;
import com.graduation.graduation_system.dto.Teacher.TeacherDTO;
import com.graduation.graduation_system.service.ApplicationService;
import com.graduation.graduation_system.service.StudentService;
import com.graduation.graduation_system.service.TeacherService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    private final StudentService studentService;

    private final TeacherService teacherService;

    private final ModelMapper modelMapper;

    @Override
    public List<ApplicationDTO> getApplications() {
        return applicationRepository.findAll().stream()
                .map(this::convertToApplicationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationDTO getApplicationById(long id) {
        return modelMapper.map(applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid Application Id:" + id)), ApplicationDTO.class);
    }

    @Override
    public CreateApplicationDTO createApplication(CreateApplicationDTO createApplicationDTO) {
        return modelMapper.map(
                applicationRepository.save(
                        modelMapper.map(createApplicationDTO, Application.class)), CreateApplicationDTO.class);
    }

    @Override
    public UpdateApplicationDTO updateApplication(long id, UpdateApplicationDTO updateApplicationDTO) {
        Application application = modelMapper.map(getApplicationById(id), Application.class);
        application.setTheme(updateApplicationDTO.getTheme());
        application.setPurpose(updateApplicationDTO.getPurpose());
        application.setTasks(updateApplicationDTO.getTasks());
        application.setTechnologies(updateApplicationDTO.getTechnologies());
        application.setStudent(updateApplicationDTO.getStudent());
        application.setTeacher(updateApplicationDTO.getTeacher());
        application.setStatus(updateApplicationDTO.getStatus());
        return modelMapper.map(applicationRepository.save(application), UpdateApplicationDTO.class);
    }

    @Override
    public void deleteApplication(long id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public List<StudentDTO> getApplicationStudents() { return studentService.getStudents(); }

    @Override
    public List<TeacherDTO> getApplicationTeachers() { return teacherService.getTeachers(); }
    private ApplicationDTO convertToApplicationDTO(Application application) { return modelMapper.map(application, ApplicationDTO.class); }
}
