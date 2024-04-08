package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.dto.MeetExpertsResponse;
import kg.it_lab.backend.Flow.dto.Page2Dto;
import kg.it_lab.backend.Flow.entities.Page2;
import kg.it_lab.backend.Flow.mapper.MeetExpertsMapper;
import kg.it_lab.backend.Flow.mappers.Page2Mapper;
import kg.it_lab.backend.Flow.repository.MeetExpertsRepository;
import kg.it_lab.backend.Flow.repository.Page1Repository;
import kg.it_lab.backend.Flow.repository.Page2Repository;
import kg.it_lab.backend.Flow.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {
    private final MeetExpertsRepository meetExpertsRepository;
    private final MeetExpertsMapper meetExpertsMapper;
    private final Page2Repository page2Repository;


    @Override
    public MeetExpertsResponse getMeetExperts() {
        return meetExpertsMapper.toDto(meetExpertsRepository.findFirstByOrderByIdDesc());
    }

    @Override
    public Page2Dto getPage2() {
        Page2 page2 = page2Repository.findFirstByOrderByIdDesc();

        return Page2Mapper.INSTANCE.toDto(page2);
    }
}
