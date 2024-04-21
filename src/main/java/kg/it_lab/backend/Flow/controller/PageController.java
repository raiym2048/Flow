package kg.it_lab.backend.Flow.controller;


import kg.it_lab.backend.Flow.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pages")
public class PageController {
    private final PageService pageService;

    @GetMapping("/getPage2")
    public ResponseEntity<?> getPage2() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(pageService.getPage2());
    }

    @GetMapping("/getPage6")
    public ResponseEntity<?> getPage6() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(pageService.getPage6());
    }

    @GetMapping("/getPage8")
    public ResponseEntity<?> getPage8() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(pageService.getPage8());
    }

    @GetMapping("/getPage9")
    public ResponseEntity<?> getPage9() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(pageService.getPage9());
    }

}
