package com.graduation.graduation_system.dto.Application;

import com.graduation.graduation_system.data.entity.Student;
import com.graduation.graduation_system.data.entity.Teacher;
import com.graduation.graduation_system.data.entity.enums.ApplicationStatus;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateApplicationDTO {
    private String theme;
    private String purpose;
    private String tasks;
    private String technologies;
    private ApplicationStatus status;
    private Student student;
    private Teacher teacher;
}

