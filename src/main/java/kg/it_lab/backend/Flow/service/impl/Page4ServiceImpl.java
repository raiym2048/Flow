package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.dto.Page4Response;
import kg.it_lab.backend.Flow.entities.Page4;
import kg.it_lab.backend.Flow.mapper.Page4Mapper;
import kg.it_lab.backend.Flow.repository.Page4Repository;
import kg.it_lab.backend.Flow.service.Page4Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Page4ServiceImpl implements Page4Service {

    private final Page4Repository page4Repository;
    private final Page4Mapper page4Mapper;

    @Override
    public Page4Response findFirstByOrderByIdDesc() {
        Optional<Page4> optionalPage = page4Repository.findFirstByOrderByIdDesc();
        return page4Mapper.toDto(optionalPage.orElse(null));
    }
}
