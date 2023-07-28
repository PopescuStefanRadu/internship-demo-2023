package com.example.secondProject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "car")
@Data
public class Car {
    @Id
    @Column(name="id")
    public Long id;

    @Column(name="brand")
    private String brand;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

}
