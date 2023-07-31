package com.example.secondProject.repository;

import com.example.secondProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {
    List<Student> findByUniversity(String university);
    List<Student> findByName(String name);
    List<Student> findByNameAndUniversity(String name, String university);
    List<Student> findByNameAndCarBrand(String name, String carBrand);
    List<Student> findByCarBrandAndCarIdGreaterThan(String carBrand, Long carId);
    List<Student> findByCarColorCodeAndCarColorShade(String code, String shade);

    @Query("select st from Student st join StudentAttendedCourse sac on st.id=sac.student.id where sac.course.code=:code")
    List<Student> findByCourseCode(@Param("code") String code);
}
