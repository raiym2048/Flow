package kg.it_lab.backend.Flow.dto;

import lombok.Data;

import java.util.List;

@Data
public class Page2Request {

    String image;

    String footer;

    String header;

    List<String> bodies;

}
