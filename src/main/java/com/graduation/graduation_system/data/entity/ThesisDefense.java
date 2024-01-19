package com.graduation.graduation_system.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "thesis_defense")
public class ThesisDefense extends BaseEntity{

    private LocalDateTime defenseDate;

    /*@OneToMany(mappedBy = "thesisDefense")
    private List<Thesis> thesisList;*/

    @OneToMany(mappedBy = "thesisDefense", cascade = CascadeType.ALL)
    private List<ThesisDefenseInfo> thesisDefenseInfos;

    @ManyToMany
    @JoinTable(
            name = "thesis_defense_teachers",
            joinColumns = @JoinColumn(name = "thesis_defense_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Teacher> teachers;


}
