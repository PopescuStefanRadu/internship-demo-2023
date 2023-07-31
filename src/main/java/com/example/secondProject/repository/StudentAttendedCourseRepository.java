package com.example.secondProject.repository;

import com.example.secondProject.entity.StudentAttendedCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentAttendedCourseRepository extends JpaRepository<StudentAttendedCourse, Long> {

    List<StudentAttendedCourse> findByCourse_Code(String code);
}
