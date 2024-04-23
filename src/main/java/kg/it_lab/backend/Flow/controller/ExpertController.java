package kg.it_lab.backend.Flow.controller;


import kg.it_lab.backend.Flow.mapper.ExpertsMapper;
import kg.it_lab.backend.Flow.service.ExpertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.PrimitiveIterator;

@RestController
@RequestMapping("/expert")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExpertController {

    private final ExpertService expertService;

    @GetMapping("/getExperts")
    public ResponseEntity<?> getExperts() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(expertService.getExperts());
    }
}
