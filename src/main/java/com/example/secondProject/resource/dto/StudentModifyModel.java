package com.example.secondProject.resource.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class StudentModifyModel {


    @Valid
    @NotNull
    private PersonalInformation personalInformation;

    private String university;

    public interface AtCreation {}
    public interface AtEdit {}

}

