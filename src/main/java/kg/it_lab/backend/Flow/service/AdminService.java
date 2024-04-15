package kg.it_lab.backend.Flow.service;

import kg.it_lab.backend.Flow.dto.ExpertsRequest;
import kg.it_lab.backend.Flow.dto.MeetExpertRequest;
import kg.it_lab.backend.Flow.dto.Page7Request;
import kg.it_lab.backend.Flow.dto.StartPageRequest;
import kg.it_lab.backend.Flow.entities.User;

import java.util.List;

public interface AdminService {
    List<User> getAllUsers(String token);

    User getUsernameFromToken(String token);

    void addExpert(ExpertsRequest expertsRequest, String token);

    void addMeetExpert(MeetExpertRequest expertsRequest, String token);

    void addStartPageData(StartPageRequest startPageRequest,String token);

    void addPage7Data(Page7Request page7Request, String token);
}
