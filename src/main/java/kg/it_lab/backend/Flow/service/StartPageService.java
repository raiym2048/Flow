package kg.it_lab.backend.Flow.service;

import kg.it_lab.backend.Flow.dto.StartPageResponse;

public interface StartPageService {
    StartPageResponse findFirstByOrderByIdDesc();
}
