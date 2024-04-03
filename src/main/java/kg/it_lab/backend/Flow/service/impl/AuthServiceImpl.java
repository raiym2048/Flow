package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.dto.AuthRequest;
import kg.it_lab.backend.Flow.dto.AuthResponse;
import kg.it_lab.backend.Flow.entities.User;
import kg.it_lab.backend.Flow.enums.Role;
import kg.it_lab.backend.Flow.exception.NotFoundException;
import kg.it_lab.backend.Flow.repository.UserRepository;
import kg.it_lab.backend.Flow.security.JwtService;
import kg.it_lab.backend.Flow.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(AuthRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (user.isEmpty()) {
            throw new NotFoundException("User not found", HttpStatus.NOT_FOUND);
        }
        if (!user.get().getRole().equals(Role.ADMIN))
            throw new NotFoundException("User is not admin", HttpStatus.NOT_FOUND);
        System.out.println(user.get().getEmail());
        System.out.println(request.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.get().getEmail(),
                    request.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            System.out.println("Success auth");
        } catch (AuthenticationException e) {
            System.out.println("bad credentials");
            throw new BadCredentialsException("Bad credentials");
        }

        Map<String, Object> extraClaims = new HashMap<>();

        String token = jwtService.generateToken(extraClaims, user.get());

        AuthResponse authResponse = new AuthResponse();
        authResponse.setEmail(user.get().getEmail());
        authResponse.setToken(token);

        return authResponse;

    }

    @Override
    public String generateToken(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        return jwtService.generateToken(extraClaims, user);
    }

    @Override
    public void register(AuthRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ADMIN);
        userRepository.save(user);
    }
}
