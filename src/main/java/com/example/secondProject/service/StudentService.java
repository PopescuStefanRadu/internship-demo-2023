package com.example.secondProject.service;

import com.example.secondProject.dto.StudentCarColorDTO;
import com.example.secondProject.entity.Student;
import com.example.secondProject.entity.StudentAttendedCourse;
import com.example.secondProject.repository.StudentRepository;
import com.example.secondProject.resource.dto.StudentFilterModel;
import com.example.secondProject.resource.dto.StudentModel;
import com.example.secondProject.resource.dto.StudentModifyModel;
import com.example.secondProject.resource.dto.mapper.StudentModelMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final Mailer mailer;

    public List<StudentModel> getFiltered(final StudentFilterModel sfm) {
        List<Specification<Student>> specs = new ArrayList<>();

        if (sfm.gradeGt != null) {
            specs.add((Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) ->
                    criteriaBuilder.gt(root.get(Student.Fields.GRADE), sfm.getGradeGt()));
        }

        if (sfm.getUniversityIn() != null && !sfm.getUniversityIn().isEmpty()) {
            specs.add((Root<Student> students, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) ->
                    students.get(Student.Fields.UNIVERSITY).in(sfm.getUniversityIn()));
        }

        if (StringUtils.hasText(sfm.getAttendedCourse())) {
            specs.add((student, query, criteriaBuilder) -> {
                Join<Student, StudentAttendedCourse> courses = student.join("courses");
                Path<Object> courseCode = courses.get("course").get("code");

                return criteriaBuilder.equal(courseCode, sfm.getAttendedCourse());
            });
        }

        List<Student> all = studentRepository.findAll(Specification.allOf(specs));

        {
            // how to do sorting
            var pageFromUi = 0;
            Page<Student> name = studentRepository.findAll(Specification.allOf(specs), PageRequest.of(pageFromUi, 10)
                    .withSort(Sort.by("name").ascending().and(Sort.by("university"))));
        }
        return all.stream().map(StudentModelMapper::fromEntity).toList();
    }
    public StudentModel updateStudent(final Long id, final StudentModifyModel studentModifyModel) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not update a student that does not exist. Id: %s".formatted(id)));

        student.setName(studentModifyModel.getPersonalInformation().getName())
                .setUniversity(studentModifyModel.getUniversity());

        Student save = studentRepository.save(student);
        return StudentModelMapper.fromEntity(student);
    }

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











