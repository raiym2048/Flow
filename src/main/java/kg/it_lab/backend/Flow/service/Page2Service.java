package kg.it_lab.backend.Flow.service;

import kg.it_lab.backend.Flow.dto.Page2Dto;
import kg.it_lab.backend.Flow.dto.page.Page2Request;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface Page2Service {


    Page2Dto create(Page2Request page2Request);

    Optional<Page2Dto> findPage2(Long id);
}
