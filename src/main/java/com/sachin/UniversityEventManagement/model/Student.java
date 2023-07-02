package com.sachin.UniversityEventManagement.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotBlank
    @Length(min = 1)
    @Pattern(regexp = "^[A-Z].*")
    private String firstName;

    @NotBlank
    @Length(min = 1)
    private String lastName;

    @NotNull
    @Min(18)
    @Max(25)
    private Integer age;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Department department;


}

