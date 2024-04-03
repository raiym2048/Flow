package kg.it_lab.backend.Flow.service;

import kg.it_lab.backend.Flow.entities.User;

import java.util.List;

public interface AdminService {
    List<User> getAllUsers(String token);

    User getUsernameFromToken(String token);
}
