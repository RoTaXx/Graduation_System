package com.graduation.graduation_system.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private String fNumber;  //Faculty number

    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String lastName;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Application application;
}
