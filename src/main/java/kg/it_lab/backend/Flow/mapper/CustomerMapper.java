package kg.it_lab.backend.Flow.mapper;

import kg.it_lab.backend.Flow.dto.CustomerResponse;
import kg.it_lab.backend.Flow.dto.ExpertResponse;
import kg.it_lab.backend.Flow.entities.Customer;
import kg.it_lab.backend.Flow.entities.Experts;

import java.util.List;

public interface CustomerMapper {
    List<CustomerResponse> toDtoS(List<Customer> all);

}
