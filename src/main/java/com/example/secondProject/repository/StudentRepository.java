package com.example.secondProject.repository;

import com.example.secondProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByUniversity(String university);
    List<Student> findByName(String name);
    List<Student> findByNameAndUniversity(String name, String university);
    List<Student> findByNameAndCarBrand(String name, String carBrand);
    List<Student> findByCarBrandAndCarIdGreaterThan(String carBrand, Long carId);
    List<Student> findByCarColorCodeAndCarColorShade(String code, String shade);
}
