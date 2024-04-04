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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Page2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String header;

    String footer;

    @OneToMany
    @JoinColumn(name = "page2_id", referencedColumnName = "id")
    List<Body> bodies;

}
