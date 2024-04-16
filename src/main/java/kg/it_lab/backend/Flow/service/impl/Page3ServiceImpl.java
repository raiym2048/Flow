package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.dto.Page3Response;
import kg.it_lab.backend.Flow.mapper.Page3Mapper;
import kg.it_lab.backend.Flow.repository.Page3Repository;
import kg.it_lab.backend.Flow.service.Page3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Page3ServiceImpl implements Page3Service {
    private final Page3Repository page3Repository;
    private final Page3Mapper page3Mapper;

    @Override
    public Page3Response getPage3() {
        return null;
    }

    @Override
    public Page3Response page3Experts() {
        return page3Mapper.toDto(page3Repository.findFirstByOrderByIdDesc());
    }
}
