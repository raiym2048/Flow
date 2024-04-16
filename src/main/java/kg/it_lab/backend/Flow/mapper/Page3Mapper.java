package kg.it_lab.backend.Flow.mapper;

import kg.it_lab.backend.Flow.dto.Page3Response;
import kg.it_lab.backend.Flow.entities.Page3;

import java.util.List;

public interface Page3Mapper {
    List<Page3Response> toDtoS(List<Page3> all);


    Page3Response toDto(Page3 firstByOrderByIdDesc);
}
