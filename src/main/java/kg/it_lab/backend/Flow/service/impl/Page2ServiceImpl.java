package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.dto.Page2Dto;
import kg.it_lab.backend.Flow.dto.page.Page2Request;
import kg.it_lab.backend.Flow.entities.Body;
import kg.it_lab.backend.Flow.entities.Page2;
import kg.it_lab.backend.Flow.mappers.Page2Mapper;
import kg.it_lab.backend.Flow.repository.BodyRepository;
import kg.it_lab.backend.Flow.repository.Page2Repository;
import kg.it_lab.backend.Flow.service.Page2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Page2ServiceImpl implements Page2Service{

    private final Page2Repository page2Repository;
    private final BodyRepository bodyRepository;

    @Override
    public Page2Dto create(Page2Request page2Request) {

        System.out.println(page2Request.getFooter());
        System.out.println(page2Request.getHeader());
        Page2 page2 = Page2.builder()
                .footer(page2Request.getFooter())
                .header(page2Request.getHeader())
                .build();

        page2Repository.save(page2);
        return Page2Mapper.INSTANCE.toDto(page2);
    }

    @Override
    public Optional<Page2Dto> findPage2(Long id) {
        Optional<Page2> page2find = page2Repository.findById(id);

        if (page2find.isPresent()){
            Page2Mapper.INSTANCE.toDto(page2find);
        }

        return null;
    }
}
