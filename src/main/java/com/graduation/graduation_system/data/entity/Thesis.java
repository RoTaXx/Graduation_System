package com.graduation.graduation_system.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "thesis")
public class Thesis extends BaseEntity{
    private String title;
    private String text;
    private LocalDate publicationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id")
    private Application application;

    @OneToOne(mappedBy = "thesis", cascade = CascadeType.ALL)
    private ThesisDefenseInfo thesisDefenseInfo;

    @OneToMany(mappedBy = "thesis", cascade = CascadeType.ALL)
    private List<Review> reviews;

}
