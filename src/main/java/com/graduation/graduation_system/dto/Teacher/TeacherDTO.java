package com.graduation.graduation_system.dto.Teacher;

import com.graduation.graduation_system.data.entity.enums.Position;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeacherDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Position position;
}
