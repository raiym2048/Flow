package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.dto.Page2Dto;
import kg.it_lab.backend.Flow.dto.page.Page2Request;
import kg.it_lab.backend.Flow.entities.Page1;
import kg.it_lab.backend.Flow.entities.Page2;
import kg.it_lab.backend.Flow.service.Page2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pages2")
public class Page2Controller {

    private final Page2Service page2Service;

    @PostMapping("/create")
    public ResponseEntity<?> page2(@RequestBody Page2Request page2Request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(page2Service.create(page2Request));
    }

    @GetMapping("/findPage2")
    public ResponseEntity<?> findPage2(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(page2Service.findPage2(id));
    }

}
