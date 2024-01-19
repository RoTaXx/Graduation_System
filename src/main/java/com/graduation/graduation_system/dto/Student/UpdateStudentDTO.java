package com.graduation.graduation_system.dto.Student;

import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateStudentDTO {
    private Long id;
    private String fNumber;
    private String firstName;
    private String lastName;
}

