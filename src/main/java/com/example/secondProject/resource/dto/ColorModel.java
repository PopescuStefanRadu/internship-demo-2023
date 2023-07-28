package com.example.secondProject.resource.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ColorModel {
    @Min(1)
    @NotNull
    private Long id;

    @Pattern(regexp = "^#[0-9a-fA-F]{6}$")
    private String code;

    private String shade;
}
