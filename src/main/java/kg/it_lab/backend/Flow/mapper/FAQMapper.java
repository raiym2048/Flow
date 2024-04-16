package kg.it_lab.backend.Flow.mapper;

import kg.it_lab.backend.Flow.dto.FAQResponse;
import kg.it_lab.backend.Flow.entities.FAQ;

public interface FAQMapper {
    FAQResponse toDto(FAQ entity);
}
