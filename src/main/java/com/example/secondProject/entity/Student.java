package com.example.secondProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    public static class Fields {
        public static final String GRADE = "grade";
        public static final String UNIVERSITY = "university";
    }

    @Id
    @Column(name = "id")
    private Long id;

    private String cnp;

    @Column(name = "name")
    private String name;

    @Column(name = "university")
    private String university;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    private LocalDate birthDate;

    private BigDecimal grade;

    private Boolean graduated;

    @OneToMany(mappedBy = "student")
    private List<StudentAttendedCourse> courses;
}
