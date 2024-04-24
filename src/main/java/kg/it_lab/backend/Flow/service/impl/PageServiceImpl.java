package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.dto.*;
import kg.it_lab.backend.Flow.mapper.*;
import kg.it_lab.backend.Flow.repository.*;
import kg.it_lab.backend.Flow.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {
    private final MeetExpertsRepository meetExpertsRepository;
    private final MeetExpertsMapper meetExpertsMapper;
    private final Page2Repository page2Repository;
    private final Page6Repository page6Repository;
    private final Page8Repository page8Repository;
    private final Page6Mapper page6Mapper;
    private final Page8Mapper page8Mapper;
    private final Page9Mapper page9Mapper;
    private final Page9Repository page9Repository;
    private final Page2Mapper page2Mapper;


    @Override
    public MeetExpertsResponse getMeetExperts() {
        return meetExpertsMapper.toDto(meetExpertsRepository.findFirstByOrderByIdDesc());
    }

    @Override
    public Page2Response getPage2() {
        return page2Mapper.toDto(page2Repository.findFirstByOrderByIdDesc());
    }

    @Override
    public Page6Response getPage6() {
        return page6Mapper.toDto(page6Repository.findFirstByOrderByIdDesc());
    }

    @Override
    public Page8Response getPage8() {
        return page8Mapper.toDto(page8Repository.findFirstByOrderByIdDesc());
    }

    @Override
    public Page9Response getPage9() {
        return page9Mapper.toDto(page9Repository.findFirstByOrderByIdDesc());
    }
}
