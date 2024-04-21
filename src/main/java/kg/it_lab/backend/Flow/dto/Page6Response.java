package kg.it_lab.backend.Flow.dto;

import kg.it_lab.backend.Flow.entities.Customer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Page6Response {

     String header;

     List<CustomerResponse> customers;

     String commentText;
}
