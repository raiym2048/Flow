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

    void addAnswer(AnswerRequest answerRequest, String token);

    void addPage8(Page8Request page8Request, String token);

    void deleteCustomer(String name, String token);

    CustomerResponse updateCustomer(CustomerRequestUpdate customerRequest, String token);

    void updatePage2(Page2Request page2Request, String token);

    void updatePage6(Page6Request page6Request, String token);

    AnswerResponse updateAnswer(AnswerRequestUpdate answerRequestUpdate, String token);

    BlogResponse addBlog(BlogRequest blogRequest, String token);

    void deleteBlog(BlogRequest blogRequest, String token);

    void updateBlog(BlogRequestUpdate blogRequestUpdate, String token);

    void addPage9(Page9Request page9Request, String token);

    void addStartPageData(StartPageRequest startPageRequest,String token);

    void addPage7Data(Page7Request page7Request, String token);
    void addPage4Data(Page4Request page4Request, String token);
    void addAnswer(AnswerFAQRequest answerRequest, String token);
    void addFAQ(FAQRequest faqRequest, String token);

    void addPage3(Page3Request page3Request, String token);

    void deleteExpert(String name, String token);

    void addBodyPage2(BodyPage2Dto bodyPage2Dto, String token);

    void addPage11(Page11Dto page11Dto, String token);
}
