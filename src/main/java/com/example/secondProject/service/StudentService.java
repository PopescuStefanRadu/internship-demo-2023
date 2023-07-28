package com.example.secondProject.service;

import com.example.secondProject.dto.StudentCarColorDTO;
import com.example.secondProject.entity.Student;
import com.example.secondProject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<String> getStudentsNamesByUniversity(String university) {
        return studentRepository.findAll()
                .stream()
                .filter(s -> university.equals(s.getUniversity()))
                .map(s -> s.getName().toUpperCase() + 10 * 2)
                .collect(Collectors.toList());
    }

    public List<Student> getByUniversity(String university) {
        return studentRepository.findByUniversity(university);

    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<StudentCarColorDTO> getSomethingSpecial(String colorCode, String colorShade) {
        return studentRepository.findByCarColorCodeAndCarColorShade(colorCode, colorShade)
                .stream()
                .map(student -> {
                    var info = new StudentCarColorDTO();
                    info.setStudentName(student.getName());
                    info.setCarBrand(student.getCar().getBrand());
                    info.setCarColor(student.getCar().getColor().getCode());
                    info.setCarShade(student.getCar().getColor().getShade());
                    return info;
                }).toList();
    }
}











