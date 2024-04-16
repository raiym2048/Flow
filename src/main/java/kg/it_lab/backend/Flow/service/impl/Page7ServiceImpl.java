package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.dto.Page7Response;
import kg.it_lab.backend.Flow.entities.Page7;
import kg.it_lab.backend.Flow.mapper.Page7Mapper;
import kg.it_lab.backend.Flow.repository.Page7Repository;
import kg.it_lab.backend.Flow.service.Page7Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Page7ServiceImpl implements Page7Service {

    private final Page7Repository page7Repository;
    private final Page7Mapper page7Mapper;

    @Override
    public Page7Response findFirstByOrderByIdDesc() {
        Optional<Page7> optionalPage = page7Repository.findFirstByOrderByIdDesc();
        return page7Mapper.toDto(optionalPage.orElse(null));
    }
}
