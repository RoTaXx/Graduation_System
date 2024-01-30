package com.graduation.graduation_system.dto.Review;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.graduation.graduation_system.data.entity.Teacher;
import com.graduation.graduation_system.data.entity.Thesis;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private Long id;
    private LocalDate uploadDate;
    private String text;
    private boolean isPositive;
    private Long thesisId;
    private Long teacherId;
}
