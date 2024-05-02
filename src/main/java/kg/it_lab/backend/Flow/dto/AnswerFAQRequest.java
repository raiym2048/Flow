package kg.it_lab.backend.Flow.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class AnswerFAQRequest {
    private String answer;
    private String question;
}
