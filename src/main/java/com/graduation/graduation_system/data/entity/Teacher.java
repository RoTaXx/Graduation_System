package com.graduation.graduation_system.data.entity;

import com.graduation.graduation_system.data.entity.enums.Position;
import jakarta.persistence.*;
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
    private String firstName;
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
