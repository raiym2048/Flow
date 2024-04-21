package kg.it_lab.backend.Flow.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Getter
@Setter
@Entity
@Builder
@Table(name = "page2")
@NoArgsConstructor
@AllArgsConstructor
public class Page2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    private String header;

    private String footer;

    @ElementCollection
    private List<String> bodies;


}
