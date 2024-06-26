package kg.it_lab.backend.Flow.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

public class MainController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
    @GetMapping("/bye")
    public String bye() {
        return "Goodbye, World!";
    }
}
