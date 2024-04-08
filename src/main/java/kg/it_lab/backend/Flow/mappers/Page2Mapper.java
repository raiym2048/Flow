package kg.it_lab.backend.Flow.mappers;

import kg.it_lab.backend.Flow.dto.Page2Dto;
import kg.it_lab.backend.Flow.entities.Page2;

import java.util.Optional;


public class Page2Mapper {

    public static final Page2Mapper INSTANCE = new Page2Mapper();

    public Page2 toEntity(Page2Dto page2Dto){

        Page2 page2 = new Page2();
        page2.setId(page2Dto.getId());
        page2.setFooter(page2Dto.getFooter());
        page2.setHeader(page2Dto.getHeader());

        return page2;
    }

    public Page2Dto toDto(Page2 page2){

        Page2Dto page2dto = new Page2Dto();
        page2dto.setId(page2.getId());
        page2dto.setFooter(page2.getFooter());
        page2dto.setHeader(page2.getHeader());

        return page2dto;
    }


    public Optional<Page2Dto> toDto(Optional<Page2> page2find) {
        Optional<Page2Dto> page2Dto = Optional.ofNullable(Page2Dto
                .builder()
                        .id(page2find.get().getId())
                        .header(page2find.get().getHeader())
                        .footer(page2find.get().getFooter())
                        .bodies(page2find.get().getBodies())
                .build());
        return page2Dto;
    }
}
