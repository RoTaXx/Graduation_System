package com.graduation.graduation_system.dto.ThesisDefense;

import com.graduation.graduation_system.dto.Thesis.ThesisDTO;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThesisDefenseInfoDTO {
    private Long id;
    private Double grade;
    private ThesisDTO thesis;
}
