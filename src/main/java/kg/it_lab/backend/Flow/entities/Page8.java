package kg.it_lab.backend.Flow.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@Table(name = "page8")
@NoArgsConstructor
@AllArgsConstructor
public class Page8 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String builder;

    @OneToMany
    List<Answer> answer;

}
