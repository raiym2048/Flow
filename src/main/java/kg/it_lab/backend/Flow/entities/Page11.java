package kg.it_lab.backend.Flow.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@Table(name = "page11")
@NoArgsConstructor
@AllArgsConstructor
public class Page11 {

    @Id
    private Long id;

    private String header;

    @Column(columnDefinition = "TEXT")
    private String image;

    private String body;

    private String emailSender;
}
