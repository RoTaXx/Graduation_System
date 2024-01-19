package com.graduation.graduation_system.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "thesis_defense_info")
public class ThesisDefenseInfo extends BaseEntity{
    private Double grade;

    @OneToOne
    @JoinColumn(name = "thesis_id")
    private Thesis thesis;

    @ManyToOne
    @JoinColumn(name = "thesis_defense_id")
    private ThesisDefense thesisDefense;
}
