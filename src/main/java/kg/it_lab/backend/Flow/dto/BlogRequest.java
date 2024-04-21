package kg.it_lab.backend.Flow.dto;

import kg.it_lab.backend.Flow.entities.CustomerBlog;
import lombok.Data;

@Data
public class BlogRequest {

    private String image;

    private String dateTime;

    private String title;

    private CustomerBlog customerBlog;
}
