package kg.it_lab.backend.Flow.repository;

import kg.it_lab.backend.Flow.entities.Page11;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Page11Repository extends JpaRepository<Page11, Long> {

    Page11 findFirstByOrderByIdDesc();
}
