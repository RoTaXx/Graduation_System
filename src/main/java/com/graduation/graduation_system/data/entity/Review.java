package com.graduation.graduation_system.data.entity;

import com.graduation.graduation_system.messages.EntityMessages;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "thesis_review")
public class Review extends BaseEntity{

    @NotNull(message = EntityMessages.CommonMessage.SubmittedDateNotNull)
    private LocalDate uploadDate;

    @Column(name = "text")
    @NotNull(message = EntityMessages.CommonMessage.TextNotNull)
    @Size(min = 10, max = 550, message = EntityMessages.CommonMessage.TextLength)
    private String text;

    @NotNull(message = "isPositive must not be null")
    @Pattern(regexp = "^(true|false)$", message = "isPositive must be either 'true' or 'false'")
    private boolean isPositive;

    @PrePersist
    protected void onCreate() {
        this.uploadDate = LocalDate.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "thesis_id")
    private Thesis thesis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

}
