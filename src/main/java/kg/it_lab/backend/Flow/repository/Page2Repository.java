package kg.it_lab.backend.Flow.repository;


import kg.it_lab.backend.Flow.entities.MeetExperts;
import kg.it_lab.backend.Flow.entities.Page2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Page2Repository extends JpaRepository<Page2, Long> {

    Page2 findFirstByOrderByIdDesc();
}
