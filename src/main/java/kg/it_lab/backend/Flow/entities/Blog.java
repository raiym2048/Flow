package kg.it_lab.backend.Flow.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@Table(name = "blog")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    private LocalDateTime dateTime;

    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    private CustomerBlog customerBlog;

}
