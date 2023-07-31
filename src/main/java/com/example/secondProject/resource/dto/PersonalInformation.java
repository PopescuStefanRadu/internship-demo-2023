package com.example.secondProject.resource.dto;

import com.example.secondProject.resource.validator.CNP;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PersonalInformation {
    @CNP(message = "Hi CNP is wrong!", groups = {StudentModifyModel.AtCreation.class})
    @NotNull(groups = {StudentModifyModel.AtCreation.class})
    @Null(groups = {StudentModifyModel.AtEdit.class})
    private String cnp;

    private String name;
}
