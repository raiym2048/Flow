package kg.it_lab.backend.Flow.repository;

import kg.it_lab.backend.Flow.entities.CustomerBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerBlogRepository extends JpaRepository<CustomerBlog, Long> {
}
