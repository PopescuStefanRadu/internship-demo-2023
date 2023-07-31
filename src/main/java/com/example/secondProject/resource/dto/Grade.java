package com.example.secondProject.resource.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Grade {
    private String courseName;
    private BigDecimal grade;
}
