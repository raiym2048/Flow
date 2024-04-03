package kg.it_lab.backend.Flow.service;

import kg.it_lab.backend.Flow.dto.AuthRequest;
import kg.it_lab.backend.Flow.dto.AuthResponse;
import kg.it_lab.backend.Flow.entities.User;

public interface AuthService {
    AuthResponse login(AuthRequest request);

    void register(AuthRequest request);
}
