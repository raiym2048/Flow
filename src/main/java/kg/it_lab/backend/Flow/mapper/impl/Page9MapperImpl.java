package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.Page9Response;
import kg.it_lab.backend.Flow.entities.Page9;
import kg.it_lab.backend.Flow.mapper.BlogMapper;
import kg.it_lab.backend.Flow.mapper.Page9Mapper;
import kg.it_lab.backend.Flow.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Page9MapperImpl implements Page9Mapper {

    private final BlogMapper blogMapper;
    private final BlogRepository blogRepository;
    @Override
    public Page9Response toDto(Page9 page9) {
        Page9Response page9Response = new Page9Response();
        page9Response.setHeader1(page9.getHeader1());
        page9Response.setHeader2(page9.getHeader2());
        page9Response.setBlogs(blogMapper.toDtoS(blogRepository.findAll()));

        return page9Response;
    }
}
