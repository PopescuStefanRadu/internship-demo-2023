package com.example.secondProject.resource;

import com.example.secondProject.resource.dto.ErrorResponseModel;
import com.example.secondProject.resource.dto.StudentModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentResource {


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
}
