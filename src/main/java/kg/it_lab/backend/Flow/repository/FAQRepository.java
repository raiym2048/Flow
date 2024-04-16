package kg.it_lab.backend.Flow.repository;

import kg.it_lab.backend.Flow.entities.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Long> {
    FAQ findFirstByOrderByIdDesc();
}
