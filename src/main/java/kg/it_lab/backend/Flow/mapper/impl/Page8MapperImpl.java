package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.Page8Response;
import kg.it_lab.backend.Flow.entities.Page8;
import kg.it_lab.backend.Flow.mapper.AnswerMapper;
import kg.it_lab.backend.Flow.mapper.Page8Mapper;
import kg.it_lab.backend.Flow.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Page8MapperImpl implements Page8Mapper{

    private final AnswerMapper answerMapper;
    private final AnswerRepository answerRepository;
    @Override
    public Page8Response toDto(Page8 page8) {

        Page8Response page8Response = new Page8Response();
        page8Response.setBuilder(page8.getBuilder());
        page8Response.setAnswer(answerMapper.toDtoS(answerRepository.findAll()));

        return page8Response;
    }
}
