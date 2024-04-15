package kg.it_lab.backend.Flow.service;

import kg.it_lab.backend.Flow.dto.*;
import kg.it_lab.backend.Flow.entities.User;

import java.util.List;

public interface AdminService {
    List<User> getAllUsers(String token);

    User getUsernameFromToken(String token);

    void addExpert(ExpertsRequest expertsRequest, String token);

    void addMeetExpert(MeetExpertRequest expertsRequest, String token);

    void addStartPageData(StartPageRequest startPageRequest,String token);

    void addPage7Data(Page7Request page7Request, String token);
    void addPage4Data(Page4Request page4Request, String token);
    void addAnswer(AnswerFAQRequest answerRequest, String token);
    void addFAQ(FAQRequest faqRequest, String token);
}
