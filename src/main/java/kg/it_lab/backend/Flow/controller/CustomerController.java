package kg.it_lab.backend.Flow.controller;


import kg.it_lab.backend.Flow.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)

public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/getCustomersAll")
    public ResponseEntity<?> getCustomersAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerService.getCustomerAll());
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<?> getCustomers(@Param("name") String name) {
        System.out.println("Name Controller: " + name);
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerService.getCustomerByName(name));
    }

}
