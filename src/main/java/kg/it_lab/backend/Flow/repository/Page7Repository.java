package kg.it_lab.backend.Flow.repository;

import kg.it_lab.backend.Flow.entities.Page7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Page7Repository extends JpaRepository<Page7, Long> {
    Optional<Page7> findFirstByOrderByIdDesc();
}
