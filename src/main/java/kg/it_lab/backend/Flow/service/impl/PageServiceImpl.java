package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.dto.MeetExpertsResponse;
import kg.it_lab.backend.Flow.mapper.MeetExpertsMapper;
import kg.it_lab.backend.Flow.repository.MeetExpertsRepository;
import kg.it_lab.backend.Flow.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {
    private final MeetExpertsRepository meetExpertsRepository;
    private final MeetExpertsMapper meetExpertsMapper;

    @Override
    public MeetExpertsResponse getMeetExperts() {
        return meetExpertsMapper.toDto(meetExpertsRepository.findFirstByOrderByIdDesc());
    }
}
