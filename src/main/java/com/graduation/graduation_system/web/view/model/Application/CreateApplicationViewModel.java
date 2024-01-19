package com.graduation.graduation_system.web.view.model.Application;

import com.graduation.graduation_system.data.entity.Student;
import com.graduation.graduation_system.data.entity.Teacher;
import com.graduation.graduation_system.data.entity.enums.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationViewModel {
    @NotBlank
    private String theme;
    @NotBlank
    private String purpose;
    @NotBlank
    private String tasks;
    @NotBlank
    private String technologies;
    private ApplicationStatus status;
    private Student student;
    private Teacher teacher;

}
