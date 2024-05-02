package kg.it_lab.backend.Flow.dto;

import lombok.Data;

import java.util.List;

@Data
public class Page8Response {

    private String builder;
    private List<AnswerResponse> answer;
}
