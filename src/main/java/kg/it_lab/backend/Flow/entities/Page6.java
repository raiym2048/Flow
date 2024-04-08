package kg.it_lab.backend.Flow.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@Table(name = "page6")
@NoArgsConstructor
@AllArgsConstructor
public class Page6 {
    @Id
    private Long id;

    private String header;

    @OneToMany
    private List<Customer> customers;

    private String commentText;


}
