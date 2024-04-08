package kg.it_lab.backend.Flow.dto;

import jakarta.persistence.OneToMany;
import kg.it_lab.backend.Flow.entities.Experts;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MeetExpertRequest {
    private String header;
    private String header2;
}
