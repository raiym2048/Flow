package kg.it_lab.backend.Flow.dto.auth;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
    private String email;
    private String password;
}
