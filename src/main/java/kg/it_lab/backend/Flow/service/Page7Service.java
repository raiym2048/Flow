package kg.it_lab.backend.Flow.service;


import kg.it_lab.backend.Flow.dto.Page7Response;

public interface Page7Service {
    Page7Response findFirstByOrderByIdDesc();
}
