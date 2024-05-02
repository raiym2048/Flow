package kg.it_lab.backend.Flow.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private String name;

    private String image;

    private String title;

    private String position;

}
