package kg.it_lab.backend.Flow.repository;

import kg.it_lab.backend.Flow.entities.Page4;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Page4Repository extends JpaRepository<Page4, Integer> {
    Optional<Page4> findFirstByOrderByIdDesc();
}
