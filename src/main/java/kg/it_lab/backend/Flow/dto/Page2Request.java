package kg.it_lab.backend.Flow.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Page2Request {

    String image;

    String footer;

    String header;

    List<String> bodies;

}
