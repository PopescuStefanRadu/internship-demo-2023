package com.example.secondProject.resource.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentFilterModel {
    public String nameEquals;
    public String nameLike;


    public LocalDate bornAfter;
    public LocalDate bornAfterEq;

    public LocalDate bornBefore;
    public LocalDate bornBeforeEq;

    public List<String> universityIn;

    public Boolean hasGraduated;

    public BigDecimal gradeGt;
    public BigDecimal gradeGtEq;

    public BigDecimal gradeLt;
    public BigDecimal gradeLtEq;
    public BigDecimal gradeGradeEq;

}
