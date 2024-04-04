package kg.it_lab.backend.Flow.controller;


import kg.it_lab.backend.Flow.dto.page.Page2Request;
import kg.it_lab.backend.Flow.entities.Body;
import kg.it_lab.backend.Flow.service.BodyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/body")
public class BodyController {

    private final BodyService bodyService;

    @PostMapping("/createBody")
    public ResponseEntity<?> body(@RequestBody String text) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bodyService.create(text));
    }

    @GetMapping("/findByAll")
    public List<Body> findAll(){
        return bodyService.findBodyByAll();
    }
}
