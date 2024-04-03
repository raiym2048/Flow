package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.entities.User;
import kg.it_lab.backend.Flow.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/users")
    List<User> users(@RequestHeader(value = "Authorization", required = false) String token){
        return adminService.getAllUsers(token);
    }

}
