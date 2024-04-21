package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.AnswerResponse;
import kg.it_lab.backend.Flow.dto.BlogResponse;
import kg.it_lab.backend.Flow.entities.Answer;
import kg.it_lab.backend.Flow.entities.Blog;
import kg.it_lab.backend.Flow.mapper.BlogMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BlogMapperImpl implements BlogMapper {

    @Override
    public List<BlogResponse> toDtoS(List<Blog> all) {

        List<BlogResponse> blogResponse = new ArrayList<>();
        for (Blog blog : all){
            blogResponse.add(toDto(blog));
        }
        return blogResponse;
    }

    public BlogResponse toDto(Blog blog){
        return BlogResponse.builder()
                .image(blog.getImage())
                .title(blog.getTitle())
                .dateTime(blog.getDateTime())
                .customerBlog(blog.getCustomerBlog())
                .build();
    }
}
