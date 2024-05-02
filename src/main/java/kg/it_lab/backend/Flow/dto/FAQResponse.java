package kg.it_lab.backend.Flow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FAQResponse {
    private String header;
    private List<AnswerFAQResponse> answers;
}
