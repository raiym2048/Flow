package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.dto.Page3Response;
import kg.it_lab.backend.Flow.service.Page3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/page3")
@CrossOrigin(origins = "*", maxAge = 3600)

@RequiredArgsConstructor
public class Page3Controller {
    private final Page3Service page3Service;

    @GetMapping("/get")
    public Page3Response page3Response(){
        return page3Service.getPage3();
    }
}
