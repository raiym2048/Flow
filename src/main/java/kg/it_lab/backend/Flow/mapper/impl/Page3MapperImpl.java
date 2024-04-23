package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.Page3Response;
import kg.it_lab.backend.Flow.entities.Page3;
import kg.it_lab.backend.Flow.mapper.Page3Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Page3MapperImpl implements Page3Mapper {

    public Page3Response toDto(Page3 page3) {
        Page3Response page3Response = new Page3Response();
        page3Response.setHeader1(page3.getHeader1());
        page3Response.setHeader2(page3.getHeader2());
        page3Response.setBody1(page3.getBody1());
        page3Response.setBody2(page3.getBody2());
        page3Response.setBody3(page3.getBody3());
        page3Response.setBody4(page3.getBody4());
        return page3Response;
    }
}
