package kg.it_lab.backend.Flow.service;

import kg.it_lab.backend.Flow.dto.Page4Response;

public interface Page4Service {
    Page4Response findFirstByOrderByIdDesc();
}
