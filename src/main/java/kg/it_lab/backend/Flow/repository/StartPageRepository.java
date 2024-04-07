package kg.it_lab.backend.Flow.repository;


import kg.it_lab.backend.Flow.entities.StartPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StartPageRepository extends JpaRepository<StartPage, Long>{
    Optional<StartPage> findFirstByOrderByIdDesc();
}
