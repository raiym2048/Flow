package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.dto.AuthRequest;
import kg.it_lab.backend.Flow.dto.AuthResponse;
import kg.it_lab.backend.Flow.entities.User;
import kg.it_lab.backend.Flow.enums.Role;
import kg.it_lab.backend.Flow.exception.NotFoundException;
import kg.it_lab.backend.Flow.repository.UserRepository;
import kg.it_lab.backend.Flow.service.AuthService;
import kg.it_lab.backend.Flow.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthResponse login(AuthRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (user.isEmpty()) {
            throw new NotFoundException("User not found", HttpStatus.NOT_FOUND);
        }
        if (!user.get().getRole().equals(Role.ADMIN))
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (Exception e) {
            throw new NotFoundException("Invalid email or password", HttpStatus.NOT_FOUND);

        }
        AuthResponse authResponse = new AuthResponse();
        authResponse.setEmail(user.get().getEmail());
        authResponse.setToken(generateToken(user.get()));

        return authResponse;

    }

    @Override
    public String generateToken(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        return jwtService.generateToken(extraClaims, user);
    }
}
