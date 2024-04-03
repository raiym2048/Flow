package kg.it_lab.backend.Flow.service.impl;


import kg.it_lab.backend.Flow.entities.User;
import kg.it_lab.backend.Flow.enums.Role;
import kg.it_lab.backend.Flow.exception.NotFoundException;
import kg.it_lab.backend.Flow.repository.UserRepository;
import kg.it_lab.backend.Flow.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
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
}
