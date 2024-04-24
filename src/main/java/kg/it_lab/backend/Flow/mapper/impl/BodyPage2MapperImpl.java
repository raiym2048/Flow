package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.BodyPage2Dto;
import kg.it_lab.backend.Flow.entities.BodyPage2;
import kg.it_lab.backend.Flow.mapper.BodyPage2Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BodyPage2MapperImpl implements BodyPage2Mapper {

    @Override
    public List<BodyPage2Dto> toDtoS(List<BodyPage2> all) {
        List<BodyPage2Dto> responseList = new ArrayList<>();
        for (BodyPage2 bodyPage2 : all){
            responseList.add(toDto(bodyPage2));
        }
        return responseList;
    }

    private BodyPage2Dto toDto(BodyPage2 bodyPage2){
        BodyPage2Dto bodyPage2Response = new BodyPage2Dto();
        bodyPage2Response.setText(bodyPage2.getText());
        bodyPage2Response.setTitle(bodyPage2.getTitle());

        return bodyPage2Response;
    }

}
