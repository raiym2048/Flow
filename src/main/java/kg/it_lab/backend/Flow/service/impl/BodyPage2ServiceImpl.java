package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.dto.BodyPage2Dto;
import kg.it_lab.backend.Flow.entities.BodyPage2;
import kg.it_lab.backend.Flow.entities.Experts;
import kg.it_lab.backend.Flow.mapper.BodyPage2Mapper;
import kg.it_lab.backend.Flow.repository.BodyPage2Repository;
import kg.it_lab.backend.Flow.service.BodyPage2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BodyPage2ServiceImpl implements BodyPage2Service {

    private final BodyPage2Repository bodyPage2Repository;
    private final BodyPage2Mapper bodyPage2Mapper;
    @Override
    public List<BodyPage2Dto> getBodyPage2() {
        List<BodyPage2> bodyPage2s = bodyPage2Repository.findAll();
        List<BodyPage2> bodyPage2Dtos = new ArrayList<>();

        for(BodyPage2 bodyPage2 : bodyPage2s) {
            BodyPage2 saveBodyPage2 = new BodyPage2();
            saveBodyPage2.setTitle(bodyPage2.getTitle());
            saveBodyPage2.setText(bodyPage2.getText());

            bodyPage2Dtos.add(saveBodyPage2);
        }
        return bodyPage2Mapper.toDtoS(bodyPage2Dtos);
    }

}
