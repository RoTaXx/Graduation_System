package com.graduation.graduation_system.web.view.model.Teacher;

import com.graduation.graduation_system.data.entity.enums.Position;
import lombok.*;
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTeacherViewModel {
    private String firstName;
    private String lastName;
    private Position position;
}
