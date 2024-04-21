package kg.it_lab.backend.Flow.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BlogRequestUpdate {

    String deleteText;

    String updateText;
}
