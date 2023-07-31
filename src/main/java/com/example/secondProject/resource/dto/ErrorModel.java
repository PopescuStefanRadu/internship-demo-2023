package com.example.secondProject.resource.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class ErrorModel {
    String code;
    String message;
}
