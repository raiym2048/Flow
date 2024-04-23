package kg.it_lab.backend.Flow.repository;

import kg.it_lab.backend.Flow.entities.Experts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertsRepository extends JpaRepository<Experts, Long> {

    Experts findByName(String name);

    @Modifying(clearAutomatically = true)
    @Query(value = "delete from experts e where e.name=:name", nativeQuery = true)
    void deleteByName(String name);
}
