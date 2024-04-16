package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.dto.FAQResponse;
import kg.it_lab.backend.Flow.mapper.FAQMapper;
import kg.it_lab.backend.Flow.repository.FAQRepository;
import kg.it_lab.backend.Flow.service.FAQService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FAQServiceImpl implements FAQService {
    private final FAQRepository faqRepository;
    private final FAQMapper faqMapper;

    @Override
    public FAQResponse getFAQ() {
        return faqMapper.toDto(faqRepository.findFirstByOrderByIdDesc());
    }
}
