package kg.it_lab.backend.Flow.service.impl;


import kg.it_lab.backend.Flow.dto.*;
import kg.it_lab.backend.Flow.entities.*;
import kg.it_lab.backend.Flow.enums.Role;
import kg.it_lab.backend.Flow.exception.NotFoundException;
import kg.it_lab.backend.Flow.repository.*;
import kg.it_lab.backend.Flow.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.util.Base64;
import java.util.List;

import static net.minidev.json.parser.JSONParser.*;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final ExpertsRepository expertsRepository;
    private final MeetExpertsRepository meetExpertsRepository;
    private final StartPageRepository startPageRepository;
    private final Page7Repository page7Repository;
    private final Page4Repository page4Repository;

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


}
