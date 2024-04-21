package kg.it_lab.backend.Flow.dto;

import lombok.Data;

@Data
public class CustomerRequestUpdate {

    private String nameDelete;
    private String nameUpdate;

    private String image;

    private String title;

    private String position;
}
