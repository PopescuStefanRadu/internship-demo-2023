package com.example.secondProject.resource;

import com.example.secondProject.entity.Color;
import com.example.secondProject.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api")
@RestController()
@RequiredArgsConstructor
public class ColorResource {

    private final ColorRepository colorRepository;

    @GetMapping("/color/{colorId}")
    public ResponseEntity<Color> getColor(@PathVariable Long colorId) {
        return ResponseEntity.ok(colorRepository.findById(colorId)
                .orElseThrow(() -> new RuntimeException("could not find color with id: %s".formatted(colorId)))
        );
    }

    // PUT /color/verde
    // POST /color/verde/brighten
    // POST /color/verde/delete
    // DELETE /color/verde
    // GET /color/verde
    // GET /colors?shade=bright


    @PutMapping("/color/{colorId}")
    public ResponseEntity<Color> createOrUpdate(@PathVariable Long colorId, @RequestBody Color color) {
//        ResponseEntity.status(200).headers(httpHeaders -> {
//            httpHeaders.add("X-Application-Name", "workshop");
//        }).body(null);
        return ResponseEntity.ok(colorRepository.save(color));
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
