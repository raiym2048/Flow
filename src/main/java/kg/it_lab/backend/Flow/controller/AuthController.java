package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.dto.AuthRequest;
import kg.it_lab.backend.Flow.dto.AuthResponse;
import kg.it_lab.backend.Flow.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public void register(@RequestBody AuthRequest request){
        authService.register(request);
    }

    @PostMapping("/login")
    AuthResponse login(@RequestBody AuthRequest request){
        return authService.login(request);
    }
    @GetMapping("/p")
    public String p(){
        return passwordEncoder.encode("password");
    }
}