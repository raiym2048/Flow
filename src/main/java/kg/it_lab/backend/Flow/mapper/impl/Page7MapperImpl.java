package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.Page7Response;
import kg.it_lab.backend.Flow.entities.Page7;
import kg.it_lab.backend.Flow.mapper.Page7Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Page7MapperImpl implements Page7Mapper {

    @Override
    public Page7Response toDto(Page7 entity) {
        var response = new Page7Response();
        response.setBody(entity.getBody());
        return response;
    }
}
