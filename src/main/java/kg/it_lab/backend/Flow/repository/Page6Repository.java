package kg.it_lab.backend.Flow.repository;

import kg.it_lab.backend.Flow.entities.Page6;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Page6Repository extends JpaRepository<Page6, Long> {

    Page6 findFirstByOrderByIdDesc();
}
