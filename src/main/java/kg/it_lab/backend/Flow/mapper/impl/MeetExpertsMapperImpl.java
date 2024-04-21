package kg.it_lab.backend.Flow.mapper.impl;


import kg.it_lab.backend.Flow.dto.MeetExpertsResponse;
import kg.it_lab.backend.Flow.entities.MeetExperts;
import kg.it_lab.backend.Flow.mapper.ExpertsMapper;
import kg.it_lab.backend.Flow.mapper.MeetExpertsMapper;
import kg.it_lab.backend.Flow.repository.ExpertsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MeetExpertsMapperImpl implements MeetExpertsMapper {
    private final ExpertsMapper expertsMapper;
    private final ExpertsRepository expertsRepository;

    @Override
    public MeetExpertsResponse toDto(MeetExperts meetExperts) {
        MeetExpertsResponse meetExpertsResponse = new MeetExpertsResponse();
        meetExpertsResponse.setHeader(meetExperts.getHeader());
        meetExpertsResponse.setHeader2(meetExperts.getHeader2());
        meetExpertsResponse.setExperts(expertsMapper.toDtoS(expertsRepository.findAll()));

        return meetExpertsResponse;
    }
}
