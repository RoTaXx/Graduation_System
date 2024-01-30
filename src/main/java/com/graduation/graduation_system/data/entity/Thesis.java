package com.graduation.graduation_system.data.entity;

import com.graduation.graduation_system.messages.EntityMessages;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Column(name = "title")
    @NotNull(message = EntityMessages.CommonMessage.TitleNotNull)
    @Size(min = 10, max = 550, message = EntityMessages.CommonMessage.TitleLength)
    private String title;

    @Column(name = "text", insertable = false, updatable = false)
    @NotNull(message = EntityMessages.CommonMessage.TextNotNull)
    @Size(min = 10, max = 550, message = EntityMessages.CommonMessage.TextLength)
    private String text;

    @Column(name = "publicationDate")
    @NotNull(message = EntityMessages.CommonMessage.SubmittedDateNotNull)
    private LocalDate publicationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id")
    private Application application;

    @OneToOne(mappedBy = "thesis", cascade = CascadeType.ALL)
    private ThesisDefenseInfo thesisDefenseInfo;

    @OneToMany(mappedBy = "thesis", cascade = CascadeType.ALL)
    private List<Review> reviews;

}
