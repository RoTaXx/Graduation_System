package com.graduation.graduation_system.web.view.model.Application;

import com.graduation.graduation_system.data.entity.Student;
import com.graduation.graduation_system.data.entity.Teacher;
import com.graduation.graduation_system.data.entity.enums.ApplicationStatus;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationViewModel {
    private Long id;
    private String theme;
    private String purpose;
    private String tasks;
    private String technologies;
    private ApplicationStatus status;
    private Student student;
    private Teacher teacher;
}
