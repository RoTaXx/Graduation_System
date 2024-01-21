package com.graduation.graduation_system.dto.Thesis;


import com.graduation.graduation_system.data.entity.Application;
import com.graduation.graduation_system.data.entity.Review;
import com.graduation.graduation_system.data.entity.ThesisDefenseInfo;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThesisDTO {
    private long id;
    private String title;
    private String text;
    private LocalDate publicationDate;
    private long application;
    private ThesisDefenseInfo thesisDefenseInfo;
    private List<Review> reviews;
}
