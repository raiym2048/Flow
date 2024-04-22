package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.dto.Page7Response;
import kg.it_lab.backend.Flow.service.Page7Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pages")
@CrossOrigin(origins = "*", maxAge = 3600)

public class Page7Controller {
    private final Page7Service page7Service;
    @GetMapping("/7")
    public Page7Response page(){
        return page7Service.findFirstByOrderByIdDesc();
    }
}
