package com.example.secondProject.resource;

import com.example.secondProject.entity.Student;
import com.example.secondProject.repository.StudentRepository;
import com.example.secondProject.resource.dto.ErrorResponseModel;
import com.example.secondProject.resource.dto.StudentFilterModel;
import com.example.secondProject.resource.dto.StudentModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentResource {

    private final StudentRepository studentRepository;

    @PostMapping(value = "/student/create")
    public ResponseEntity<?> createStudent(@Validated(StudentModel.AtCreation.class) @RequestBody StudentModel studentModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ErrorResponseModel.fromBindingErrors(bindingResult));
        }
        return ResponseEntity.ok(Map.of());
    }


    @PostMapping(value = "/student/{id}/update")
    public ResponseEntity<?> updateStudent(@PathVariable Long id,  @Validated(StudentModel.AtEdit.class) @RequestBody StudentModel studentModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ErrorResponseModel.fromBindingErrors(bindingResult));
        }
        return ResponseEntity.ok(Map.of());
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getFiltered(@ModelAttribute StudentFilterModel sfm) {
        List<Specification<Student>> specs = new ArrayList<>();

        if (sfm.gradeGt != null) {
            specs.add((Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) ->
                    criteriaBuilder.gt(root.get(Student.Fields.GRADE), sfm.getGradeGt()));
        }

        if (sfm.getUniversityIn() != null && !sfm.getUniversityIn().isEmpty()) {
            specs.add((Root<Student> students, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) ->
                    students.get(Student.Fields.UNIVERSITY).in(sfm.getUniversityIn()));
        }


        List<Student> all = studentRepository.findAll(Specification.allOf(specs));
        return ResponseEntity.ok(all);
    }

    public static Specification<Student> isLongTermCustomer() {
        return (Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> null;
    }
}
