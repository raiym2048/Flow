package kg.it_lab.backend.Flow.mappers;

import kg.it_lab.backend.Flow.dto.Page2Dto;
import kg.it_lab.backend.Flow.entities.Page2;

import java.util.Optional;


public class Page2Mapper {

    public static final Page2Mapper INSTANCE = new Page2Mapper();

    public Page2 toEntity(Page2Dto page2Dto) {

        return Page2
                .builder()
                .footer(page2Dto.getFooter())
                .image(page2Dto.getImage())
                .header(page2Dto.getHeader())
                .bodies(page2Dto.getBodies())
                .build();
    }

    public Page2Dto toDto(Page2 page2) {

        return Page2Dto
                .builder()
                .footer(page2.getFooter())
                .image(page2.getImage())
                .header(page2.getHeader())
                .bodies(page2.getBodies())
                .build();
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
