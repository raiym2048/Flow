package kg.it_lab.backend.Flow.service;

import kg.it_lab.backend.Flow.dto.CustomerResponse;
import kg.it_lab.backend.Flow.dto.ExpertResponse;

import java.util.List;

public interface ExpertService {

    List<ExpertResponse> getExperts();
}
