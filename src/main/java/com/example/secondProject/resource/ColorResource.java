package com.example.secondProject.resource;

import com.example.secondProject.entity.Color;
import com.example.secondProject.repository.ColorRepository;
import com.example.secondProject.resource.dto.ColorModel;
import com.example.secondProject.resource.dto.ErrorResponseModel;
import com.example.secondProject.resource.validator.UniqueConstraintValidator;
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
import java.util.Optional;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ColorResource {

    private final UniqueConstraintValidator uniqueConstraintValidator;
    private final ColorRepository colorRepository;

//    @ExceptionHandler(EntityNotFoundException.class)
//    @ResponseBody
//    public ResponseEntity<Object> handleNotFoundException(EntityNotFoundException e) {
//        return ResponseEntity.status(404).body(Map.of("hello", "world"));
//    } // TODO

    @GetMapping(value = "/color/{colorId}", produces = "application/json")
    public ResponseEntity<Color> getColor(@PathVariable Long colorId) {
        return colorRepository.findById(colorId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
    }

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
            log.info("Validation result: {}", colorValidationResult);
            ErrorResponseModel build = ErrorResponseModel.builder()
                    .errors(colorValidationResult.getAllErrors().stream()
                            .map(objectError -> ErrorResponseModel.ErrorModel.builder()
                                    .code(objectError.getCode())
                                    .message(objectError.getDefaultMessage())
                                    .build()
                            )
                            .toList())
                    .build();
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
//        ResponseEntity.status(200).headers(httpHeaders -> {
//            httpHeaders.add("X-Application-Name", "workshop");
//        }).body(null);
        Optional<Color> byId = colorRepository.findById(colorId);// TODO handle exceptions globally
        if (byId.isPresent()) {
            colorRepository.deleteById(colorId);
            return ResponseEntity.ok().body(byId.get());
        }
        return ResponseEntity.notFound().build();
    }

}
