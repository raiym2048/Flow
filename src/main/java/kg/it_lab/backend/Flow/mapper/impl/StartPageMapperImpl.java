package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.StartPageResponse;
import kg.it_lab.backend.Flow.entities.StartPage;
import kg.it_lab.backend.Flow.mapper.StartPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartPageMapperImpl implements StartPageMapper {
    @Override
    public StartPageResponse toDto(StartPage entity) {
        var response = new StartPageResponse();
        response.setHeader1(entity.getHeader1());
        response.setHeader2(entity.getHeader2());
        response.setBody1(entity.getBody1());
        response.setBody2(entity.getBody2());
        response.setFooter1(entity.getFooter1());
        response.setFooter2(entity.getFooter2());
        response.setImage1(entity.getImage1());
        response.setImage2(entity.getImage2());
        response.setImage3(entity.getImage3());
        response.setImage4(entity.getImage4());
        return response;
    }
}
