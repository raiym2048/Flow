package kg.it_lab.backend.Flow.controller;


import kg.it_lab.backend.Flow.dto.Page4Response;
import kg.it_lab.backend.Flow.service.Page4Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pages")
public class Page4Controller {
    private final Page4Service page4Service;
    @GetMapping("/4")
    public Page4Response page4() {
         return page4Service.findFirstByOrderByIdDesc();
    }
}
