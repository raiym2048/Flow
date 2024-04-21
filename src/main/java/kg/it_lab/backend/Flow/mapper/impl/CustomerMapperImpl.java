package kg.it_lab.backend.Flow.mapper.impl;

import kg.it_lab.backend.Flow.dto.CustomerResponse;
import kg.it_lab.backend.Flow.entities.Customer;
import kg.it_lab.backend.Flow.mapper.CustomerMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public List<CustomerResponse> toDtoS(List<Customer> all) {
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : all) {
            customerResponses.add(toDto(customer));
        }
        return customerResponses;
    }

    public CustomerResponse toDto(Customer customer) {
        CustomerResponse customerResponse = CustomerResponse.builder()
                .name(customer.getName())
                .title(customer.getTitle())
                .image(customer.getImage())
                .position(customer.getPosition())
                .build();
        return customerResponse;
    }
}
