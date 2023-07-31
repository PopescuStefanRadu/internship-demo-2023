package com.example.secondProject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"student_id", "course_id"}
        )
)
public class StudentAttendedCourse {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Course course;

    private BigDecimal grade;
}
