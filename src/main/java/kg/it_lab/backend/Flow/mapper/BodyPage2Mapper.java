package kg.it_lab.backend.Flow.mapper;

import kg.it_lab.backend.Flow.dto.BodyPage2Dto;
import kg.it_lab.backend.Flow.entities.BodyPage2;

import java.util.List;

public interface BodyPage2Mapper {

    List<BodyPage2Dto> toDtoS(List<BodyPage2> all);
}
