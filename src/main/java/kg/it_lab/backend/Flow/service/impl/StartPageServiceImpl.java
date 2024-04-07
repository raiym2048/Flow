package kg.it_lab.backend.Flow.service.impl;



import kg.it_lab.backend.Flow.dto.StartPageResponse;
import kg.it_lab.backend.Flow.entities.StartPage;
import kg.it_lab.backend.Flow.mapper.StartPageMapper;
import kg.it_lab.backend.Flow.repository.StartPageRepository;
import kg.it_lab.backend.Flow.service.StartPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StartPageServiceImpl implements StartPageService {
    private final StartPageRepository repository;
    private final StartPageMapper mapper;

    @Override
    public StartPageResponse findFirstByOrderByIdDesc() {
        Optional<StartPage> pageOptional = repository.findFirstByOrderByIdDesc();
        if (pageOptional.isEmpty())
            return null;
        return mapper.toDto(pageOptional.get());
    }

}
