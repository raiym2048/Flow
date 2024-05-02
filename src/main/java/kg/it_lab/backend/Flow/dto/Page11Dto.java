package kg.it_lab.backend.Flow.dto;

import jakarta.servlet.annotation.HandlesTypes;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Page11Dto {

    private String header;

    private String image;

    private String body;

    private String emailSender;
}
