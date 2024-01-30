package com.graduation.graduation_system.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graduation.graduation_system.data.entity.enums.ApplicationStatus;
import com.graduation.graduation_system.messages.EntityMessages;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "application")
public class Application extends BaseEntity{

    @Column(name = "theme")
    @NotNull(message = EntityMessages.ApplicationMessage.SubjectNotNull)
    @Size(min = 5, max = 30, message = EntityMessages.ApplicationMessage.SubjectLength)
    private String theme;

    @Column(name = "purpose")
    @NotNull(message = EntityMessages.ApplicationMessage.PurposeNotNull)
    @Size(min = 5, max = 50, message = EntityMessages.ApplicationMessage.PurposeLength)
    private String purpose;

    @Column(name = "tasks")
    //@NotNull(message = EntityMessages.ApplicationMessage.TaskNotNull)
    @Size(min = 5, max = 30)
    private String tasks;

    private String technologies;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    @JsonIgnoreProperties(value = "application")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    @JsonIgnoreProperties(value = "application")
    private Teacher teacher;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
}