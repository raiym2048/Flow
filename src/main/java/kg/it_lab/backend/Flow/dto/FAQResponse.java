package kg.it_lab.backend.Flow.dto;

import kg.it_lab.backend.Flow.entities.AnswerFAQ;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FAQResponse {
    private String header;
    private List<AnswerFAQResponse> answers;
}
