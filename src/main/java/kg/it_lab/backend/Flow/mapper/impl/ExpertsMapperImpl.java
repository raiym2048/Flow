package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.ExpertResponse;
import kg.it_lab.backend.Flow.entities.Experts;
import kg.it_lab.backend.Flow.mapper.ExpertsMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExpertsMapperImpl implements ExpertsMapper {
    @Override
    public List<ExpertResponse> toDtoS(List<Experts> all) {
        List<ExpertResponse> expertResponses = new ArrayList<>();
        for (Experts expert : all) {
            expertResponses.add(toDto(expert));
        }
        return expertResponses;
    }

    private ExpertResponse toDto(Experts expert) {
        ExpertResponse expertResponse = new ExpertResponse();
        expertResponse.setName(expert.getName());
        expertResponse.setPosition(expert.getPosition());
        expertResponse.setPhoto(expert.getPhoto());
        return expertResponse;
    }
}
