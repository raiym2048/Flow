package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.Page2Response;
import kg.it_lab.backend.Flow.entities.Page2;
import kg.it_lab.backend.Flow.mapper.BodyPage2Mapper;
import kg.it_lab.backend.Flow.mapper.Page2Mapper;
import kg.it_lab.backend.Flow.repository.BodyPage2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Page2MapperImpl implements Page2Mapper {

    private final BodyPage2Mapper bodyPage2Mapper;
    private final BodyPage2Repository bodyPage2Repository;


    @Override
    public Page2Response toDto(Page2 page2) {
        Page2Response page2Response = new Page2Response();
        page2Response.setHeader(page2.getHeader());
        page2Response.setImage(page2.getImage());
        page2Response.setFooter(page2.getFooter());
        page2Response.setBodies(bodyPage2Mapper.toDtoS(bodyPage2Repository.findAll()));

        return page2Response;
    }
}
