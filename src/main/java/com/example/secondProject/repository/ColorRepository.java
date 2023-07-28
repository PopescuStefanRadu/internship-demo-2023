package com.example.secondProject.repository;

import com.example.secondProject.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Long> {
    List<Color> findByCode(String code);
}
