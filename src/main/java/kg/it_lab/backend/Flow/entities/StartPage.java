package kg.it_lab.backend.Flow.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "start_page")
public class StartPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String header1;
    private String header2;
    private String body1;
    private String body2;
    private String footer1;
    private String footer2;
    private String image1;
    private String image2;
    private String image3;
    private String image4;

}
