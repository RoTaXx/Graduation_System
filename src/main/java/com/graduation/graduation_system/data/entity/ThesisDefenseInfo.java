package com.graduation.graduation_system.data.entity;

import com.graduation.graduation_system.messages.EntityMessages;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "thesis_defense_info")
public class ThesisDefenseInfo extends BaseEntity{

    @Column(name = "grade")
    @Size(min = 2, max = 6, message = EntityMessages.DefenseMessage.GradeValue)
    private Double grade;

    @OneToOne
    @JoinColumn(name = "thesis_id")
    private Thesis thesis;

    @ManyToOne
    @JoinColumn(name = "thesis_defense_id")
    private ThesisDefense thesisDefense;
}
