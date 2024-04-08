package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.dto.Page2Dto;
import kg.it_lab.backend.Flow.entities.Body;
import kg.it_lab.backend.Flow.entities.Page2;
import kg.it_lab.backend.Flow.repository.BodyRepository;
import kg.it_lab.backend.Flow.repository.Page2Repository;
import kg.it_lab.backend.Flow.service.BodyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BodyServiceImpl implements BodyService {

    private final BodyRepository bodyRepository;
    private final Page2Repository page2Repository;
    @Override
    public Body create(String text, Long id) {
        System.out.println("TEXT : " + text);
        System.out.println("ID : " + id);
        Optional<Page2> page2 = page2Repository.findById(id);
        Body body = Body.builder()
                .text(text)
                .page2(Page2.builder()
                        .id(page2.get().getId())
                        .build())
                .build();
        return bodyRepository.save(body);
    }

    @Override
    public List<Body> findBodyByAll() {
        return bodyRepository.findAll();
    }
}
