package com.example.secondProject.resource.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentModel {
    private String cnp;
    private String name;
    private String university;
    private List<Grade> grades;
}
