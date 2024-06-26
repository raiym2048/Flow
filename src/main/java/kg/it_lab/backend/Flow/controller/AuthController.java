package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.dto.auth.AuthRequest;
import kg.it_lab.backend.Flow.dto.auth.AuthResponse;
import kg.it_lab.backend.Flow.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)

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