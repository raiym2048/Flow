package kg.it_lab.backend.Flow.entities;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(columnDefinition = "TEXT")
    private String image;

    private String header;

    private String footer;

    @OneToMany
    private List<BodyPage2> bodies;


}
