package kg.it_lab.backend.Flow.dto.mapper;

import java.util.List;

public interface Mappable <E, D>{ //Entity -> Dto

    E fromDto(D dto);
    D toDto(E entity);

    List<D> toDto(List<E> entities);

}