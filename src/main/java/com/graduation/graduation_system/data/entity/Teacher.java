package com.graduation.graduation_system.data.entity;

import com.graduation.graduation_system.data.entity.enums.Position;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher extends BaseEntity{
    @Column(name="firstName", nullable = false)
    @NotBlank(message = "Teacher first name cannot be blank!")
    @Size(max = 20, message = "Teacher first name has to be within 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Teacher first name has to start with capital letter!")
    @Size(min = 1, max = 20, message="Min 5, Max 20")
    private String firstName;

    @Column(name="lastName", nullable = false)
    @NotBlank(message = "Teacher last name cannot be blank!")
    @Size(max = 20, message = "Teacher last name has to be within 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Teacher last name has to start with capital letter!")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Application> applications;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Review> reviews;

   @ManyToMany(mappedBy = "teachers")
    private List<ThesisDefense> thesisDefense;
}
