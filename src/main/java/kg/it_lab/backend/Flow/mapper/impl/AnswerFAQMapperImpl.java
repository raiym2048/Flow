package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.AnswerFAQResponse;
import kg.it_lab.backend.Flow.entities.AnswerFAQ;
import kg.it_lab.backend.Flow.mapper.AnswerFAQMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnswerFAQMapperImpl implements AnswerFAQMapper {

    @Override
    public List<AnswerFAQResponse> toDtoS(List<AnswerFAQ> answers){
        List<AnswerFAQResponse> answerResponses = new ArrayList<>();
        for (AnswerFAQ answer : answers) {
            answerResponses.add(toDto(answer));
        }
        return answerResponses;
    }

    private AnswerFAQResponse toDto(AnswerFAQ answer){
        AnswerFAQResponse answerResponse = new AnswerFAQResponse();
        answerResponse.setAnswer(answer.getAnswer());
        answerResponse.setQuestion(answer.getQuestion());
        return answerResponse;
    }
}
