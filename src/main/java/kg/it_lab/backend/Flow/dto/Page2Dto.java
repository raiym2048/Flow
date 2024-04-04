package kg.it_lab.backend.Flow.dto;



import kg.it_lab.backend.Flow.entities.Body;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Page2Dto {
    Long id;

    String header;

    String footer;

    List<Body> bodies;

}
