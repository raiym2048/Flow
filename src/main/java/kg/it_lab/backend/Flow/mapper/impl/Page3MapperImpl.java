package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.Page3Response;
import kg.it_lab.backend.Flow.entities.Page3;
import kg.it_lab.backend.Flow.mapper.Page3Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Page3MapperImpl implements Page3Mapper {
    @Override
    public List<Page3Response> toDtoS(List<Page3> all) {
        List<Page3Response> page3Responses = new ArrayList<>();
        for (Page3 page3 : all) {
            page3Responses.add(toDto(page3));
        }
        return page3Responses;
    }

    public Page3Response toDto(Page3 page3) {
        Page3Response page3Response = new Page3Response();
        page3Response.setHeader1(page3.getHeader1());
        page3Response.setHeader2(page3.getHeader2());
        page3Response.setBody(page3.getBody());
        return page3Response;
    }
}
