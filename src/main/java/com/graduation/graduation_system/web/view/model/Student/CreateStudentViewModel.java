package com.graduation.graduation_system.web.view.model.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentViewModel {

    @NotBlank
    private String fNumber;
    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String lastName;
}
