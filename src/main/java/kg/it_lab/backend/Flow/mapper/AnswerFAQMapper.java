package kg.it_lab.backend.Flow.mapper;

import kg.it_lab.backend.Flow.dto.AnswerFAQResponse;
import kg.it_lab.backend.Flow.entities.AnswerFAQ;

import java.util.List;

public interface AnswerFAQMapper {
    List<AnswerFAQResponse> toDtoS(List<AnswerFAQ> answers);
}
