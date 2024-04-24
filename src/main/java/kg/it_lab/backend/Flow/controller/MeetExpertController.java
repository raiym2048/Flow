package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.dto.MeetExpertsResponse;
import kg.it_lab.backend.Flow.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meet-experts")
@RequiredArgsConstructor
public class MeetExpertController {

    private final PageService pageService;

    @GetMapping("/get")
    public MeetExpertsResponse meetExpertsResponse() {
        return pageService.getMeetExperts();
    }
}
