package com.example.secondProject.resource;

import com.example.secondProject.entity.Color;
import com.example.secondProject.repository.ColorRepository;
import com.example.secondProject.resource.dto.ColorModel;
import com.example.secondProject.resource.dto.ErrorResponseModel;
import com.example.secondProject.resource.validator.UniqueConstraintValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ColorResource {

    private final UniqueConstraintValidator uniqueConstraintValidator;
    private final ColorRepository colorRepository;

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Object> handleNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(404).body(Map.of("hello", "world"));
    }

    @GetMapping(value = "/color/{colorId}", produces = "application/json")
    public ResponseEntity<Color> getColor(@PathVariable Long colorId) {
        return colorRepository.findById(colorId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Could not find color with id: %s".formatted(colorId)));
    }

    // PUT /color/verde
    // POST /color/verde/brighten
    // POST /color/verde/delete
    // DELETE /color/verde
    // GET /color/verde
    // GET /colors?shade=bright

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(uniqueConstraintValidator);
    } // TODO how to make global

    // chestii folosite in parametrii unui HandlerMethod (functie a unui endpoint)
    // @PathVariable -
    // @RequestParam -
    // @RequestHeader maybe? -
    // @RequestBody -
    // @RequestPart -
    // @ModelAttribute - Trebe folosit - cu exmplu la filtrari
    // BindingResult -

    @PutMapping("/color/{colorId}")
    public ResponseEntity<?> createOrUpdate(@PathVariable Long colorId, @Validated @RequestBody ColorModel color, BindingResult colorValidationResult) {
        if (colorValidationResult.hasErrors())  {
            ErrorResponseModel build = ErrorResponseModel.fromBindingErrors(colorValidationResult);
            return ResponseEntity.badRequest().body(build);
        }
//        ResponseEntity.status(200).headers(httpHeaders -> {
//            httpHeaders.add("X-Application-Name", "workshop");
//        }).body(null);
        return ResponseEntity.ok(colorRepository.save(
                Color.builder()
                        .id(colorId)
                        .code(color.getCode())
                        .shade(color.getShade())
                        .build()));
    }

    @DeleteMapping("/color/{colorId}")
    public ResponseEntity<Color> delete(@PathVariable Long colorId) {
        Color color = colorRepository.findById(colorId)
                .orElseThrow(() -> new EntityNotFoundException("Could not find color with id: %s".formatted(colorId)));
        colorRepository.delete(color);
        return ResponseEntity.ok(color);
    }

}
