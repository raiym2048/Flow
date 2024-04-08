package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.dto.MeetExpertsResponse;
import kg.it_lab.backend.Flow.entities.Page1;
import kg.it_lab.backend.Flow.repository.Page1Repository;
import kg.it_lab.backend.Flow.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pages")
public class PageController {
    private final Page1Repository page1Repository;
    private final PageService pageService;

    @GetMapping("/page1")
    public Page1 page1() {
        Optional<Page1> page1 = page1Repository.findById(1L);
        if (page1.isPresent()) {
            return page1.get();
        }
        return new Page1();
    }

    //some comments

    @GetMapping("/get")
    public ResponseEntity<?> getPage2() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(pageService.getPage2());
    }

}
