package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.service.BodyPage2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bodyPage2")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class BodyPage2Controller {

    private final BodyPage2Service bodyPage2Service;
    @GetMapping("/getExperts")
    public ResponseEntity<?> getExperts() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bodyPage2Service.getBodyPage2());
    }

}
