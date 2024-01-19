package com.graduation.graduation_system.dto.Student;

import com.graduation.graduation_system.data.entity.Application;
import com.graduation.graduation_system.data.entity.Thesis;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDTO {
    private Long id;
    private String fNumber;
    private String firstName;
    private String lastName;
}
