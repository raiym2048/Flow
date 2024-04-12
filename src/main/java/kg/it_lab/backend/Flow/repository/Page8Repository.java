package kg.it_lab.backend.Flow.repository;

import kg.it_lab.backend.Flow.entities.Page8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Page8Repository extends JpaRepository<Page8, Long> {

    Page8 findFirstByOrderByIdDesc();
}
