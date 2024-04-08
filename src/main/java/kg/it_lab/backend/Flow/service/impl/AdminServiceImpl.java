package kg.it_lab.backend.Flow.service.impl;


import kg.it_lab.backend.Flow.dto.CustomerRequest;
import kg.it_lab.backend.Flow.dto.ExpertsRequest;
import kg.it_lab.backend.Flow.dto.MeetExpertRequest;
import kg.it_lab.backend.Flow.dto.Page2Request;
import kg.it_lab.backend.Flow.entities.*;
import kg.it_lab.backend.Flow.enums.Role;
import kg.it_lab.backend.Flow.exception.NotFoundException;
import kg.it_lab.backend.Flow.mapper.CustomerMapper;
import kg.it_lab.backend.Flow.repository.*;
import kg.it_lab.backend.Flow.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final ExpertsRepository expertsRepository;
    private final MeetExpertsRepository meetExpertsRepository;
    private final Page2Repository page2Repository;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
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

        String[] chunks = token.substring(7).split("\\.");//Bearer
        Base64.Decoder decoder = Base64.getUrlDecoder();

        JSONParser jsonParser = new JSONParser();
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
                .name(customerRequest.getName())
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
}
