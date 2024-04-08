package kg.it_lab.backend.Flow.service;


import kg.it_lab.backend.Flow.dto.Page2Dto;
import kg.it_lab.backend.Flow.entities.Body;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BodyService {
    Body create(String text, Long id);

    List<Body> findBodyByAll();
}
