package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.entities.Page1;
import kg.it_lab.backend.Flow.repository.Page1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pages")
public class Page1Controller {
    private final Page1Repository page1Repository;

    @GetMapping("/page1")
    public Page1 page1() {
        Optional<Page1> page1 = page1Repository.findById(1L);
        if (page1.isPresent()) {
            return page1.get();
        }
        return new Page1();
    }

}
