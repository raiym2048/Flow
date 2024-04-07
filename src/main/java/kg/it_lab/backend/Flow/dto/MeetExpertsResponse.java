package kg.it_lab.backend.Flow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MeetExpertsResponse {
    private String header;
    private String header2;

    List<ExpertResponse> experts;
}
