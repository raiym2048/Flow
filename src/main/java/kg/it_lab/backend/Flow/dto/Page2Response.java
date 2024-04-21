package kg.it_lab.backend.Flow.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Page2Response {

    String image;

    String header;

    String footer;

    List<String> bodies;
}
