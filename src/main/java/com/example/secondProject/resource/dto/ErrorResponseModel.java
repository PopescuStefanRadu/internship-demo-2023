package com.example.secondProject.resource.dto;


import lombok.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.function.Function;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class ErrorResponseModel {
    List<ErrorModel> errors;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    @Builder
    public static class ErrorModel {
        String code;
        String message;
    }

    public static ErrorResponseModel fromBindingErrors(BindingResult bindingResult) {
        List<ErrorModel> list = bindingResult.getAllErrors().stream()
                .map(ErrorResponseModel::getObjectErrorErrorModelFunction)
                .toList();

        return ErrorResponseModel.builder()
                .errors(list)
                .build();
    }

    private static ErrorModel getObjectErrorErrorModelFunction(ObjectError objectError) {
        return ErrorModel.builder()
                .code(objectError.getCodes()[0])
                .message(objectError.getDefaultMessage())
                .build();
    }
}
