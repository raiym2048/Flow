package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.Page11Dto;
import kg.it_lab.backend.Flow.entities.Page11;
import kg.it_lab.backend.Flow.mapper.Page11Mapper;
import org.springframework.stereotype.Component;

@Component
public class Page11DtoImpl implements Page11Mapper {
    @Override
    public Page11Dto toDto(Page11 page11) {
        Page11Dto page11Dto = new Page11Dto();
        page11Dto.setBody(page11.getBody());
        page11Dto.setHeader(page11.getHeader());
        page11Dto.setImage(page11.getImage());
        page11Dto.setEmailSender(page11.getEmailSender());

        return page11Dto;
    }
}
