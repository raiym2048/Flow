package kg.it_lab.backend.Flow.dto.mapper;

import kg.it_lab.backend.Flow.dto.StartPageDto;
import kg.it_lab.backend.Flow.entities.StartPage;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface StartPageMapper extends Mappable<StartPage, StartPageDto>{
}
