package kg.it_lab.backend.Flow.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StartPageDto {
    @NotNull(message = "Id must be not null.")
    private Long id;
    private String header1;
    private String header2;
    private String body1;
    private String body2;
    private String footer1;
    private String footer2;
}
