package kg.it_lab.backend.Flow.repository;

import kg.it_lab.backend.Flow.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByName(String name);

    @Modifying(clearAutomatically = true)
    @Query(value = "delete from customers c where c.name=:name", nativeQuery = true)
    void deleteByName(String name);

    Customer findByName(String name);

//    @Modifying(clearAutomatically = true)
//    @Query(value = "update from customers c where c.name=:name", nativeQuery = true)
//    void updateByName(String name);
//    @Modifying(clearAutomatically = true)
//    @Query(value = "update customers set c.name = c where c.name=:name", nativeQuery = true)
 //   Customer updateById(Customer customer);
}
