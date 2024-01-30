package com.graduation.graduation_system.dto.Student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateStudentDTO {
    @NotBlank
    private String fNumber;
    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String lastName;
}

