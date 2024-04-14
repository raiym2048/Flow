package kg.it_lab.backend.Flow.mapper;

import kg.it_lab.backend.Flow.dto.AnswerResponse;
import kg.it_lab.backend.Flow.dto.BlogResponse;
import kg.it_lab.backend.Flow.entities.Answer;
import kg.it_lab.backend.Flow.entities.Blog;

import java.util.List;

public interface BlogMapper {

    List<BlogResponse> toDtoS(List<Blog> all);
}
