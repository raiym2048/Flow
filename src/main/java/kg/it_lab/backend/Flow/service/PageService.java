package kg.it_lab.backend.Flow.service;

import kg.it_lab.backend.Flow.dto.MeetExpertsResponse;
import kg.it_lab.backend.Flow.dto.Page2Response;
import kg.it_lab.backend.Flow.dto.Page6Response;
import kg.it_lab.backend.Flow.dto.Page8Response;

public interface PageService {
    MeetExpertsResponse getMeetExperts();

    Page2Response getPage2();

    Page6Response getPage6();

    Page8Response getPage8();
}
