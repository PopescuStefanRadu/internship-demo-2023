package com.example.secondProject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "university")
    private String university;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;
}
