package kg.it_lab.backend.Flow.service.impl;

import kg.it_lab.backend.Flow.dto.CustomerResponse;
import kg.it_lab.backend.Flow.entities.Customer;
import kg.it_lab.backend.Flow.mapper.impl.CustomerMapperImpl;
import kg.it_lab.backend.Flow.repository.CustomerRepository;
import kg.it_lab.backend.Flow.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapperImpl customerMapper;
    @Override
    public CustomerResponse getCustomerByName(String name) {
        Customer customer = customerRepository.findCustomerByName(name);
        return customerMapper.toDto(customer);

    }

    @Override
    public List<CustomerResponse> getCustomerAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponse> findCustomer = new ArrayList<>();
        for (Customer customer : customers){
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setImage(customer.getImage());
            customerResponse.setName(customer.getName());
            customerResponse.setPosition(customer.getPosition());
            customerResponse.setTitle(customer.getTitle());
            findCustomer.add(customerResponse);
        }
         return findCustomer;
    }
}
