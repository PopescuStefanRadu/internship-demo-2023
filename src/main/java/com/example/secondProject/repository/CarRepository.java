package com.example.secondProject.repository;

import com.example.secondProject.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    //select * from car ca inner join color co
    // on ca.color_id = co.id
    // where code = 'red';
    List<Car> findByColorCode(String code);
}
