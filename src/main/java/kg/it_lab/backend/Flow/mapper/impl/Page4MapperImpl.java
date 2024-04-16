package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.Page4Response;
import kg.it_lab.backend.Flow.entities.Page4;
import kg.it_lab.backend.Flow.mapper.Page4Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Page4MapperImpl implements Page4Mapper {
    @Override
    public Page4Response toDto(Page4 entity) {
        var response = new Page4Response();
        response.setBody(entity.getBody());
        return response;
    }
}
