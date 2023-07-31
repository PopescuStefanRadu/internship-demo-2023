package com.example.secondProject.resource.dto;

import com.example.secondProject.resource.validator.CNP;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.groups.Default;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class StudentModel {


    @Valid
    @NotNull
    private PersonalInformation personalInformation;

    private String university;

    public interface AtCreation {}
    public interface AtEdit {}

}

