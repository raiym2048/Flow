package kg.it_lab.backend.Flow.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {
    String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    );
}
