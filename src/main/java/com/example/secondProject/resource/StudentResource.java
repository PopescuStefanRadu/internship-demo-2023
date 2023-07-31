package com.example.secondProject.resource;

import com.example.secondProject.entity.Student;
import com.example.secondProject.resource.dto.ErrorResponseModel;
import com.example.secondProject.resource.dto.StudentFilterModel;
import com.example.secondProject.resource.dto.StudentModel;
import com.example.secondProject.resource.dto.StudentModifyModel;
import com.example.secondProject.service.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
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

    private final StudentService studentService;

    @PostMapping(value = "/student/create")
    public ResponseEntity<?> createStudent(@Validated(StudentModifyModel.AtCreation.class) @RequestBody StudentModifyModel studentModifyModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ErrorResponseModel.fromBindingErrors(bindingResult));
        }
        return ResponseEntity.ok(Map.of());
    }


    @PostMapping(value = "/student/{id}/update")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @Validated(StudentModifyModel.AtEdit.class) @RequestBody StudentModifyModel studentModifyModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ErrorResponseModel.fromBindingErrors(bindingResult));
        }

        return ResponseEntity.ok(studentService.updateStudent(id, studentModifyModel));
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentModel>> getFiltered(@ModelAttribute StudentFilterModel sfm) {
        return ResponseEntity.ok(studentService.getFiltered(sfm));
    }
}
