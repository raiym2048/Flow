package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.dto.StartPageResponse;
import kg.it_lab.backend.Flow.service.StartPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/pages")
public class StartPageController {
    private final StartPageService service;

    @GetMapping("/1")
    public StartPageResponse page() {
        return service.findFirstByOrderByIdDesc();
    }
}
