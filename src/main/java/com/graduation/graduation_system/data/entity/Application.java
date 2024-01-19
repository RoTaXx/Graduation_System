package com.graduation.graduation_system.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graduation.graduation_system.data.entity.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "application")
public class Application extends BaseEntity{

    private String theme;

    private String purpose;

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