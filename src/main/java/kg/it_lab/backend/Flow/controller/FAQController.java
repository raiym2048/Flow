package kg.it_lab.backend.Flow.controller;


import kg.it_lab.backend.Flow.dto.FAQResponse;
import kg.it_lab.backend.Flow.entities.FAQ;
import kg.it_lab.backend.Flow.service.FAQService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pages")
@CrossOrigin(origins = "*", maxAge = 3600)

public class FAQController {
    private final FAQService faqService;
    @GetMapping("/8")
    public FAQResponse getFAQ() {
        return faqService.getFAQ();
    }
}
