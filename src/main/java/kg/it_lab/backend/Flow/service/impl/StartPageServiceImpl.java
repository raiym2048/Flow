package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.entities.StartPage;
import kg.it_lab.backend.Flow.exception.NotFoundException;
import kg.it_lab.backend.Flow.repository.StartPageRepository;
import kg.it_lab.backend.Flow.service.StartPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StartPageServiceImpl implements StartPageService {
    private final StartPageRepository startPageRepository;


    @Override
    public StartPage getById(Long id) {
        return startPageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Start page not found",
                        HttpStatus.BAD_REQUEST));
    }
}
