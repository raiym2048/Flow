package kg.it_lab.backend.Flow.repository;

import kg.it_lab.backend.Flow.entities.Page3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Page3Repository extends JpaRepository<Page3, Long>{
    Page3 findFirstByOrderByIdDesc();
}
