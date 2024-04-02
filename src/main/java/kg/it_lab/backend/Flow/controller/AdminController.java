package kg.it_lab.backend.Flow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final PasswordEncoder passwordEncoder;
    @GetMapping("/users")
    public String getUsers() {
        return "List of users";
    }

    @GetMapping("/p")
    public String p(){
        return passwordEncoder.encode("password");
    }
}
