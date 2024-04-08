package kg.it_lab.backend.Flow.mapper;

import kg.it_lab.backend.Flow.dto.ExpertResponse;
import kg.it_lab.backend.Flow.entities.Experts;

import java.util.List;

public interface ExpertsMapper {
    List<ExpertResponse> toDtoS(List<Experts> all);
}
