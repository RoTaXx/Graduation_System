package com.graduation.graduation_system.dto.Review;

import com.graduation.graduation_system.data.entity.Teacher;
import com.graduation.graduation_system.data.entity.Thesis;
import com.graduation.graduation_system.messages.EntityMessages;
import jakarta.validation.constraints.Size;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewDTO {

    @Size(min = 10, max = 550, message = EntityMessages.CommonMessage.TextLength)
    private String text;

    private boolean isPositive;
    private Long thesisId;
    private Long teacherId;
}
