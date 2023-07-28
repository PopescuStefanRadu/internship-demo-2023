package com.example.secondProject.resource.dto;

import com.example.secondProject.resource.validator.CNP;
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
public class PersonalInformation {
    @CNP(message = "Hi CNP is wrong!", groups = {StudentModel.AtCreation.class})
    @NotNull(groups = {StudentModel.AtCreation.class})
    @Null(groups = {StudentModel.AtEdit.class})
    private String cnp;

    private String name;
}
