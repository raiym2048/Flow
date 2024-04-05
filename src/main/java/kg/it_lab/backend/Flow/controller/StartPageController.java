package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.dto.StartPageDto;
import kg.it_lab.backend.Flow.dto.mapper.StartPageMapper;
import kg.it_lab.backend.Flow.entities.StartPage;
import kg.it_lab.backend.Flow.service.StartPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/start-page")
public class StartPageController {
    private final StartPageService startPageService;
    private final StartPageMapper startPageMapper;

    @GetMapping("/{id}")
    public StartPageDto startPage(@PathVariable Long id) {
        StartPage page = startPageService.getById(id);
        return startPageMapper.toDto(page);
    }
}
