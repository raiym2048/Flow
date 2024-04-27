package kg.it_lab.backend.Flow.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String position;

    @Column(columnDefinition = "TEXT")
    private String image;

    private String title;

//    @ManyToOne
//    private Page6 page6;


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
