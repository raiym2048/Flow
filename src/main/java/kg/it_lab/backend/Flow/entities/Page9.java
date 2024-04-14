package kg.it_lab.backend.Flow.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@Table(name = "page9")
@NoArgsConstructor
@AllArgsConstructor
public class Page9 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String header1;

    String header2;

    @OneToMany
    List<Blog> blogs;

}
