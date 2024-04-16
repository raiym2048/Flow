package kg.it_lab.backend.Flow.mapper;

import kg.it_lab.backend.Flow.dto.Page7Response;
import kg.it_lab.backend.Flow.entities.Page7;

public interface Page7Mapper {
    Page7Response toDto(Page7 entity);
}
