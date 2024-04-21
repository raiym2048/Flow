package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.AnswerFAQResponse;
import kg.it_lab.backend.Flow.dto.FAQResponse;
import kg.it_lab.backend.Flow.entities.FAQ;
import kg.it_lab.backend.Flow.mapper.AnswerFAQMapper;
import kg.it_lab.backend.Flow.mapper.FAQMapper;
import kg.it_lab.backend.Flow.repository.AnswerFAQRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class FAQMapperImpl implements FAQMapper {
    private final AnswerFAQMapper answerMapper;
    private final AnswerFAQRepository answerRepo;

    @Override
    public FAQResponse toDto(FAQ entity) {
        FAQResponse dto = new FAQResponse();
        dto.setHeader(entity.getHeader());
        List<AnswerFAQResponse> list = answerMapper.toDtoS(answerRepo.findAll());
        dto.setAnswers(list);
        return dto;
    }
}
