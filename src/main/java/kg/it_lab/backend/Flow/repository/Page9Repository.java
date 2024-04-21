package kg.it_lab.backend.Flow.repository;

import kg.it_lab.backend.Flow.entities.Page9;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Page9Repository extends JpaRepository<Page9, Long> {
    Page9 findFirstByOrderByIdDesc();

}
