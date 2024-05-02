package kg.it_lab.backend.Flow.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Page3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String header1;
    @Column(columnDefinition = "TEXT")
    private String header2;

    private String body1;
    private String body2;
    private String body3;
    private String body4;



}
