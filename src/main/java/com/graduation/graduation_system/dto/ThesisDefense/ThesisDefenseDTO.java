package com.graduation.graduation_system.dto.ThesisDefense;

import com.graduation.graduation_system.dto.Teacher.TeacherDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThesisDefenseDTO {
    private Long id;
    private LocalDateTime defenseDate;
    private List<ThesisDefenseInfoDTO> thesisDefenseInfos;
    private List<TeacherDTO> teachers;
}
