package kg.it_lab.backend.Flow.service;

import kg.it_lab.backend.Flow.dto.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerResponse getCustomerByName(String name);

    List<CustomerResponse> getCustomerAll();
}
