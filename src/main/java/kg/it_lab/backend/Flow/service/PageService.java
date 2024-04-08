package kg.it_lab.backend.Flow.service;

import kg.it_lab.backend.Flow.dto.MeetExpertsResponse;
import kg.it_lab.backend.Flow.dto.Page2Response;

public interface PageService {
    MeetExpertsResponse getMeetExperts();

    Page2Response getPage2();

}
