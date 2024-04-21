package kg.it_lab.backend.Flow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerFAQRequest {
    private String answer;
    private String question;
}
