package com.example.secondProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "color")
@Data
public class Color {
    @Id
    @Column(name="id")
    public Long id;

    @Column(name="code")
    private String code;

    @Column(name="shade")
    private String shade;
}
