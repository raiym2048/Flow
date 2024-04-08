package kg.it_lab.backend.Flow.repository;

import kg.it_lab.backend.Flow.entities.MeetExperts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetExpertsRepository extends JpaRepository<MeetExperts, Long> {
    MeetExperts findFirstByOrderByIdDesc();
}
