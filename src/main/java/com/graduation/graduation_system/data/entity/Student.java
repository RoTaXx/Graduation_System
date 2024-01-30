package com.graduation.graduation_system.data.entity;

import com.graduation.graduation_system.messages.EntityMessages;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "student")
public class Student extends BaseEntity{

    @NotNull(message = EntityMessages.StudentMessage.FnNotNull)
    @Size(min = 7, max = 7, message = EntityMessages.StudentMessage.FnLength)
    @Column(name = "fNumber")
    private String fNumber;  //Faculty number

    @Column(name="firstName", nullable = false)
    @NotBlank(message = "Student first name cannot be blank!")
    @Size(max = 20, message = "Student first name has to be within 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Student first name has to start with capital letter!")
    @Size(min = 1, max = 20, message="Min 5, Max 20")
    private String firstName;

    @Column(name="lastName", nullable = false)
    @NotBlank(message = "Student last name cannot be blank!")
    @Size(max = 20, message = "Student last name has to be within 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Student last name has to start with capital letter!")
    @Size(min = 1, max = 20, message="Min 5, Max 20")
    private String lastName;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Application application;
}
