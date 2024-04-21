package kg.it_lab.backend.Flow.repository;

import kg.it_lab.backend.Flow.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
