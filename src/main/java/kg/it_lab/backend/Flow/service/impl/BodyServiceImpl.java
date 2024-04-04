package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.entities.Body;
import kg.it_lab.backend.Flow.repository.BodyRepository;
import kg.it_lab.backend.Flow.service.BodyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodyServiceImpl implements BodyService {

    private final BodyRepository bodyRepository;
    @Override
    public Body create(String text) {
        Body body = Body.builder()
                .text(text)
                .build();
        return bodyRepository.save(body);
    }

    @Override
    public List<Body> findBodyByAll() {
        return bodyRepository.findAll();
    }
}
