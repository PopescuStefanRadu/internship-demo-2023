package com.example.secondProject.resource.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE }) // TODO exmplu pentru type use? WTF?
@Retention(RUNTIME)
@Constraint(validatedBy = CNPValidator.class)
@Documented
public @interface CNP {

    String message() default "CNP invalid";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
