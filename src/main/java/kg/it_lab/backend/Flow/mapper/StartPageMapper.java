package kg.it_lab.backend.Flow.mapper;

import kg.it_lab.backend.Flow.dto.StartPageResponse;
import kg.it_lab.backend.Flow.entities.StartPage;

public interface StartPageMapper {
     StartPageResponse toDto(StartPage entity);
}
