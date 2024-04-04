package kg.it_lab.backend.Flow.service;

import kg.it_lab.backend.Flow.dto.auth.AuthRequest;
import kg.it_lab.backend.Flow.dto.auth.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest request);

    void register(AuthRequest request);
}
