package com.example.secondProject.service;

import com.example.secondProject.entity.Car;
import com.example.secondProject.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getCarsByColor(String color) {
        return carRepository.findByColorCode(color);
    }
}
