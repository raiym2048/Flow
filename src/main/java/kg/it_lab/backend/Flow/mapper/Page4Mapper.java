package kg.it_lab.backend.Flow.mapper;

import kg.it_lab.backend.Flow.dto.Page4Response;
import kg.it_lab.backend.Flow.entities.Page4;


public interface Page4Mapper {
    Page4Response toDto(Page4 entity);
}
