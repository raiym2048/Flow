package kg.it_lab.backend.Flow.dto;

import kg.it_lab.backend.Flow.entities.Blog;
import lombok.Data;

import java.util.List;

@Data
public class Page9Response {

    String header1;

    String header2;

    List<BlogResponse> blogs;
}
