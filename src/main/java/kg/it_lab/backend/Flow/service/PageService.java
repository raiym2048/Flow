package kg.it_lab.backend.Flow.service;

import kg.it_lab.backend.Flow.dto.*;

public interface PageService {
    MeetExpertsResponse getMeetExperts();

    Page2Response getPage2();

    Page6Response getPage6();

    Page8Response getPage8();

    Page9Response getPage9();

    Page11Dto getPage11();
}
