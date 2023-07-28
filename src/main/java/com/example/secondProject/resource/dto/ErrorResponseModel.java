package com.example.secondProject.resource.dto;


import lombok.*;

import java.util.List;

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
}
