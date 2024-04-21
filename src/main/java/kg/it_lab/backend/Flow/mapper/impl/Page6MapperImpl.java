package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.Page6Response;
import kg.it_lab.backend.Flow.entities.Page6;
import kg.it_lab.backend.Flow.mapper.CustomerMapper;
import kg.it_lab.backend.Flow.mapper.Page6Mapper;
import kg.it_lab.backend.Flow.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Page6MapperImpl implements Page6Mapper {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    @Override
    public Page6Response toDto(Page6 page6) {

        Page6Response page6Response = new Page6Response();
        page6Response.setHeader(page6.getHeader());
        page6Response.setCommentText(page6.getCommentText());
        page6Response.setCustomers(customerMapper.toDtoS(customerRepository.findAll()));
        return page6Response;
    }
}
