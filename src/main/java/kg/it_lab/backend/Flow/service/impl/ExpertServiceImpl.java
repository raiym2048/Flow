package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.dto.ExpertResponse;
import kg.it_lab.backend.Flow.entities.Experts;
import kg.it_lab.backend.Flow.mapper.ExpertsMapper;
import kg.it_lab.backend.Flow.repository.ExpertsRepository;
import kg.it_lab.backend.Flow.service.ExpertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpertServiceImpl implements ExpertService {

    private final ExpertsRepository expertsRepository;
    private final ExpertsMapper expertsMapper;
    @Override
    public List<ExpertResponse> getExperts() {
        List<Experts> getExperts = new ArrayList<>();
        List<Experts> expertsList = expertsRepository.findAll();
        for (Experts ex : expertsList){
            Experts experts = new Experts();
            experts.setName(ex.getName());
            experts.setPhoto(ex.getPhoto());
            experts.setPosition(ex.getPosition());

            getExperts.add(experts);
        }

        return expertsMapper.toDtoS(getExperts);
    }
}
