package com.example.secondProject.resource;

import com.example.secondProject.resource.dto.ErrorModel;
import com.example.secondProject.resource.dto.ErrorResponseModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalAdvices {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Object> handleNotFoundException(EntityNotFoundException e) {
        ErrorModel error = ErrorModel.builder()
                .code("notFound")
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponseModel.builder()
                        .errors(List.of(error))
                        .build());
    }
}
