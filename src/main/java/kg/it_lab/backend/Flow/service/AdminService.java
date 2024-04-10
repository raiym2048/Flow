package kg.it_lab.backend.Flow.service;

import kg.it_lab.backend.Flow.dto.*;
import kg.it_lab.backend.Flow.entities.User;

import java.util.List;

public interface AdminService {
    List<User> getAllUsers(String token);

    User getUsernameFromToken(String token);

    void addExpert(ExpertsRequest expertsRequest, String token);

    void addMeetExpert(MeetExpertRequest expertsRequest, String token);

    void addPage2(Page2Request page2Request, String token);

    void addCustomer(CustomerRequest customerRequest, String token);

    void addCustomerAll(List<CustomerRequest> customerRequest, String token);

    void addPage6(Page6Request page6Requests, String token);
}
