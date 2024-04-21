package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.AnswerResponse;
import kg.it_lab.backend.Flow.entities.Answer;
import kg.it_lab.backend.Flow.mapper.AnswerMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnswerMapperImpl implements AnswerMapper {
    @Override
    public List<AnswerResponse> toDtoS(List<Answer> all) {
        List<AnswerResponse> answerResponses = new ArrayList<>();
        for (Answer ans : all){
            answerResponses.add(toDto(ans));
        }
        return answerResponses;
    }

    public AnswerResponse toDto(Answer answer){
        AnswerResponse answerResponse = new AnswerResponse();
        answerResponse.setAnswerQuestion(answer.getAnswerQuestion());
        answerResponse.setAnswerText(answer.getAnswerText());

        return answerResponse;
    }
}
