package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.dto.AuthRequest;
import kg.it_lab.backend.Flow.dto.AuthResponse;
import kg.it_lab.backend.Flow.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    AuthResponse login(@RequestBody AuthRequest request){
        return authService.login(request);
    }
}
