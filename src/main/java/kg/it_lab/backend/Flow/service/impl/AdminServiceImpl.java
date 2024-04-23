package kg.it_lab.backend.Flow.service.impl;


import jakarta.transaction.Transactional;
import kg.it_lab.backend.Flow.config.DateFormat;
import kg.it_lab.backend.Flow.dto.*;
import kg.it_lab.backend.Flow.entities.*;
import kg.it_lab.backend.Flow.enums.Role;
import kg.it_lab.backend.Flow.exception.NotFoundException;
import kg.it_lab.backend.Flow.mapper.impl.AnswerMapperImpl;
import kg.it_lab.backend.Flow.mapper.impl.BlogMapperImpl;
import kg.it_lab.backend.Flow.mapper.impl.CustomerMapperImpl;
import kg.it_lab.backend.Flow.repository.*;
import kg.it_lab.backend.Flow.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.util.*;

import static net.minidev.json.parser.JSONParser.*;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final ExpertsRepository expertsRepository;
    private final MeetExpertsRepository meetExpertsRepository;
    private final Page2Repository page2Repository;
    private final CustomerRepository customerRepository;
    private final Page6Repository page6Repository;
    private final AnswerRepository answerRepository;
    private final Page8Repository page8Repository;
    private final CustomerMapperImpl customerMapperImpl;
    private final AnswerMapperImpl answerMapperImpl;
    private final BlogRepository blogRepository;
    private final BlogMapperImpl blogMapperImpl;
    private final CustomerBlogRepository customerBlogRepository;
    private final Page9Repository page9repository;
    private final StartPageRepository startPageRepository;
    private final Page7Repository page7Repository;
    private final Page4Repository page4Repository;
    private final AnswerFAQRepository answerFAQRepository;
    private final FAQRepository faqRepository;
    private final Page3Repository page3Repository;


    @Override
    public List<User> getAllUsers(String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        return userRepository.findAll();
    }
    @Override
    public User getUsernameFromToken(String token) {
        if (token==null)
            throw new NotFoundException("Token is empty", HttpStatus.NOT_FOUND);

        String[] chunks = token.substring(7).split("\\.");  //Bearer
        Base64.Decoder decoder = Base64.getUrlDecoder();

        JSONParser jsonParser = new JSONParser(DEFAULT_PERMISSIVE_MODE);
        JSONObject object = null;
        try {
            object = (JSONObject) jsonParser.parse(decoder.decode(chunks[1]));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return userRepository.findByEmail(String.valueOf(object.get("sub"))).orElseThrow(() -> new NotFoundException("No user in database with ur token! ReLogIn pls",
                HttpStatus.NOT_FOUND));
    }

    @Override
    public void addExpert(ExpertsRequest expertsRequest, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        Experts experts = new Experts();
        experts.setName(expertsRequest.getName());
        experts.setPhoto(expertsRequest.getPhoto());
        experts.setPosition(expertsRequest.getPosition());
        expertsRepository.save(experts);
    }

    @Override
    public void addMeetExpert(MeetExpertRequest expertsRequest, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        MeetExperts experts = new MeetExperts();
        experts.setHeader(expertsRequest.getHeader());
        experts.setHeader2(expertsRequest.getHeader2());
        meetExpertsRepository.save(experts);

    }

    @Override
    public void addStartPageData(StartPageRequest request, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }

        StartPage page = new StartPage();
        page.setHeader1(request.getHeader1());
        page.setHeader2(request.getHeader2());
        page.setFooter1(request.getFooter1());
        page.setBody1(request.getBody1());
        page.setBody2(request.getBody2());
        page.setImage1(request.getImage1());
        page.setImage2(request.getImage2());
        page.setImage3(request.getImage3());
        page.setImage4(request.getImage4());
        startPageRepository.save(page);
    }

    @Override
    public void addPage7Data(Page7Request pageRequest, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        Page7 page = new Page7();
        page.setBody(pageRequest.getBody());
        page7Repository.save(page);
    }

    @Override
    public void addPage4Data(Page4Request pageRequest, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        Page4 page = new Page4();
        page.setBody(pageRequest.getBody());
        page4Repository.save(page);
    }

    @Override
    public void addAnswer(AnswerFAQRequest answerRequest, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        AnswerFAQ answerFAQ = new AnswerFAQ();
        answerFAQ.setAnswer(answerRequest.getAnswer());
        answerFAQ.setQuestion(answerRequest.getQuestion());
        answerFAQRepository.save(answerFAQ);
    }

    @Override
    public void addFAQ(FAQRequest faqRequest, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        FAQ faq = new FAQ();
        faq.setHeader(faqRequest.getHeader());
        faqRepository.save(faq);
    }

    @Override
    public void addPage3(Page3Request page3Request, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        Page3 page3 = new Page3();
        page3.setBody1(page3Request.getBody1());
        page3.setBody2(page3Request.getBody2());
        page3.setBody3(page3Request.getBody3());
        page3.setBody4(page3Request.getBody4());
        page3.setHeader1(page3Request.getHeader1());
        page3.setHeader2(page3Request.getHeader2());

        page3Repository.save(page3);
    }

    @Override
    @Transactional
    public void deleteExpert(String name, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }

        expertsRepository.deleteByName(name);
    }

    @Override
    public void addPage2(Page2Request page2Request, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        Page2 page2 = new Page2();
        page2.setImage(page2Request.getImage());
        page2.setHeader(page2Request.getHeader());
        page2.setFooter(page2Request.getFooter());
        page2.setBodies(page2Request.getBodies());
        page2Repository.save(page2);
    }

    @Override
    public void addCustomer(CustomerRequest customerRequest, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        Customer customer = Customer.builder()
                .name(customerRequest.getName().trim())
                .title(customerRequest.getTitle())
                .image(customerRequest.getImage())
                .position(customerRequest.getPosition())
                .build();
        customerRepository.save(customer);
    }

    @Override
    public void addCustomerAll(List<CustomerRequest> customerRequest, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        List<Customer> customers = new ArrayList<>();

        for (CustomerRequest customer : customerRequest){
            Customer saveCustomer = new Customer();
            saveCustomer.setName(customer.getName());
            saveCustomer.setTitle(customer.getTitle());
            saveCustomer.setPosition(customer.getPosition());
            saveCustomer.setImage(customer.getImage());
            customers.add(saveCustomer);
        }

        customerRepository.saveAll(customers);
    }

    @Override
    public void addPage6(Page6Request page6Requests, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        List<Customer> customers = customerRepository.findAll();
        Page6 page6 = new Page6();
        page6.setHeader(page6Requests.getHeader());
        page6.setCommentText(page6Requests.getCommentText());
        page6.setCustomers(customers);

        page6Repository.save(page6);
    }

    @Override
    public void addAnswer(AnswerRequest answerRequest, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        Answer answer = Answer.builder()
                .answerQuestion(answerRequest.getAnswerQuestion())
                .answerText(answerRequest.getAnswerText())
                .build();

        answerRepository.save(answer);

    }

    @Override
    public void addPage8(Page8Request page8Request, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        List<Answer> answers = answerRepository.findAll();
        Page8 page8 = Page8.builder()
                .builder(page8Request.getBuilder())
                .answer(answers)
                .build();
        page8Repository.save(page8);
    }

    @Override
    @Transactional
    public void deleteCustomer(String name, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        customerRepository.deleteByName(name);
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequestUpdate customerRequest, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        Customer customer = customerRepository.findByName(customerRequest.getNameDelete());

        customer.setName(customerRequest.getNameUpdate());
        customer.setTitle(customerRequest.getTitle());
        customer.setPosition(customerRequest.getPosition());
        customer.setImage(customerRequest.getImage());

        customerRepository.save(customer);

        return customerMapperImpl.toDto(customer);
    }

    @Override
    public void updatePage2(Page2Request page2Request, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        Page2 page2 = page2Repository.findFirstByOrderByIdDesc();
        page2.setImage(page2Request.getImage());
        page2.setFooter(page2Request.getFooter());
        page2.setHeader(page2Request.getHeader());
        page2.setBodies(page2Request.getBodies());

        page2Repository.save(page2);
    }

    @Override
    public void updatePage6(Page6Request page6Request, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        Page6 page6 = page6Repository.findFirstByOrderByIdDesc();
        page6.setHeader(page6Request.getHeader());
        page6.setCommentText(page6.getCommentText());

        page6Repository.save(page6);
    }

    @Override
    @Transactional
    public AnswerResponse updateAnswer(AnswerRequestUpdate answerRequestUpdate, String token) {
        User admin = getUsernameFromToken(token);
        if (!admin.getRole().equals(Role.ADMIN)){
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        }
        answerRepository.findByAnswerQuestionAndAnswerText
                        (answerRequestUpdate.getAnswerQuestionDelete(), answerRequestUpdate.getAnswerTextDelete());
        Answer answer = Answer.builder()
                .answerText(answerRequestUpdate.getAnswerTextUpdate())
                .answerQuestion(answerRequestUpdate.getAnswerQuestionUpdate())
                .build();
        answerRepository.save(answer);

        return answerMapperImpl.toDto(answerRepository.findFirstByOrderByIdDesc());
    }

    @Override
    public BlogResponse addBlog(BlogRequest blogRequest) {

        CustomerBlog customerBlog = new CustomerBlog();
        customerBlog.setName(blogRequest.getCustomerBlog().getName());
        customerBlog.setImage(blogRequest.getCustomerBlog().getImage());
        Blog blog = Blog
                .builder()
                .customerBlog(customerBlog)
                .image(blogRequest.getImage())
                .dateTime(DateFormat.dateFormatУMD(blogRequest.getDateTime()))
                .title(blogRequest.getTitle())
                .build();

        return blogMapperImpl.toDto(blogRepository.save(blog));
    }

    @Override
    public void deleteBlog(BlogRequest blogRequest) {
        List<Blog> blogs = blogRepository.findAll();

        for (Blog blog : blogs){
            if(blog.getImage().equals(blogRequest.getImage())){
                blogRepository.delete(blog);
                break;
            }
            if(blog.getTitle().equals(blogRequest.getTitle())){
                blogRepository.delete(blog);
                break;
            }
            if((blog.getCustomerBlog().getName()).equals(blogRequest.getCustomerBlog().getName())){
                blogRepository.delete(blog);
                break;
            }
            if((blog.getCustomerBlog().getImage()).equals(blogRequest.getCustomerBlog().getImage())){
                blogRepository.delete(blog);
                break;
            }
        }

    }

    @Override
    @Transactional
    public void updateBlog(BlogRequestUpdate blogRequestUpdate) {
        List<Blog> blogs = blogRepository.findAll();

        for (Blog blog : blogs){
            if(blog.getImage().equals(blogRequestUpdate.getDeleteText())){
                CustomerBlog customerBlog = new CustomerBlog();
                customerBlog.setImage(blog.getCustomerBlog().getImage());
                customerBlog.setName(blog.getCustomerBlog().getName());

                Blog updateBlog = Blog
                        .builder()
                        .dateTime(blog.getDateTime())
                        .image(blogRequestUpdate.getUpdateText())
                        .customerBlog(customerBlog)
                        .title(blog.getTitle())
                        .build();
                blogRepository.delete(blog);
                blogRepository.save(updateBlog);
                break;
            }
            if(blog.getTitle().equals(blogRequestUpdate.getDeleteText())){
                CustomerBlog customerBlog = new CustomerBlog();
                customerBlog.setImage(blog.getCustomerBlog().getImage());
                customerBlog.setName(blog.getCustomerBlog().getName());

                Blog updateBlog = Blog
                        .builder()
                        .dateTime(blog.getDateTime())
                        .image(blog.getImage())
                        .customerBlog(customerBlog)
                        .title(blogRequestUpdate.getUpdateText())
                        .build();
                blogRepository.delete(blog);
                blogRepository.save(updateBlog);
                break;
            }
            if((blog.getCustomerBlog().getName()).equals(blogRequestUpdate.getDeleteText())){
                CustomerBlog customerBlog = new CustomerBlog();
                customerBlog.setImage(blog.getCustomerBlog().getImage());
                customerBlog.setName(blogRequestUpdate.getUpdateText());

                customerBlogRepository.delete(blog.getCustomerBlog());
                Blog updateBlog = Blog
                        .builder()
                        .dateTime(blog.getDateTime())
                        .image(blog.getImage())
                        .customerBlog(customerBlog)
                        .title(blog.getTitle())
                        .build();
                blogRepository.delete(blog);
                blogRepository.save(updateBlog);
                break;
            }
            if((blog.getCustomerBlog().getImage()).equals(blogRequestUpdate.getDeleteText())){
                CustomerBlog customerBlog = new CustomerBlog();
                customerBlog.setName(blog.getCustomerBlog().getName());
                customerBlog.setImage(blogRequestUpdate.getUpdateText());
                Blog updateBlog = Blog
                        .builder()
                        .dateTime(blog.getDateTime())
                        .image(blog.getImage())
                        .customerBlog(customerBlog)
                        .title(blog.getTitle())
                        .build();
                blogRepository.delete(blog);
                blogRepository.save(updateBlog);
                break;
            }
        }
    }

    @Override
    public void addPage9(Page9Request page9Request) {
        List<Blog> blogs = blogRepository.findAll();
        Page9 page9 = Page9.builder()
                .header1(page9Request.getHeader1())
                .header2(page9Request.getHeader2())
                .blogs(blogs)
                .build();
        page9repository.save(page9);
    }

}
