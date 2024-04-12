package kg.it_lab.backend.Flow.mapper;

import kg.it_lab.backend.Flow.dto.AnswerResponse;
import kg.it_lab.backend.Flow.entities.Answer;

import java.util.List;

public interface AnswerMapper {
    List<AnswerResponse> toDtoS(List<Answer> all);

}
