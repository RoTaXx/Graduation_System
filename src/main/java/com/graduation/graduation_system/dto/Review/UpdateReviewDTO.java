package com.graduation.graduation_system.dto.Review;

import com.graduation.graduation_system.data.entity.Teacher;
import com.graduation.graduation_system.data.entity.Thesis;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReviewDTO {
    private String text;
    private boolean isPositive;
}
