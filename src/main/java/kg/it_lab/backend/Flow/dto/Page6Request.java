package kg.it_lab.backend.Flow.dto;

import jakarta.persistence.OneToMany;
import kg.it_lab.backend.Flow.entities.Customer;
import lombok.Data;

import java.util.List;

@Data
public class Page6Request {

    private String header;

    private String commentText;
}
