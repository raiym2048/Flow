package kg.it_lab.backend.Flow.dto;

import kg.it_lab.backend.Flow.entities.CustomerBlog;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BlogResponse {

    private String image;

    private LocalDateTime dateTime;

    private String title;

    private CustomerBlog customerBlog;
}
