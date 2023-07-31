package com.example.secondProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Course {

    @Id
    private Long id;

    private String code;

    private String name;
}
