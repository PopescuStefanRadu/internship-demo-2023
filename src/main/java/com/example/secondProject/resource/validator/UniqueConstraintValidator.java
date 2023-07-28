package com.example.secondProject.resource.validator;

import com.example.secondProject.repository.ColorRepository;
import com.example.secondProject.resource.dto.ColorModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UniqueConstraintValidator implements Validator {
    private final ColorRepository colorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        // clazz = ColorModel.class
        return ColorModel.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ColorModel cm = (ColorModel) target;
        if (colorRepository.existsById(cm.getId())) {
            errors.reject("EntityAlreadyExists", "entity with id %s should not already exist".formatted(cm.getId()));
        }
    }

}
