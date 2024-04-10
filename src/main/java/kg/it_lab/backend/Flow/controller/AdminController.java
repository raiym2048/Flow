package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.dto.*;
import kg.it_lab.backend.Flow.entities.User;
import kg.it_lab.backend.Flow.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/users")
    List<User> users(@RequestHeader(value = "Authorization", required = false) String token){
        return adminService.getAllUsers(token);
    }

    @PostMapping("/addExpert")
    public void addExpert(@RequestBody ExpertsRequest expertsRequest, @RequestHeader("Authorization") String token){
        adminService.addExpert(expertsRequest, token);
    }

    @PostMapping("/addMeetExpert")
    public void addMeetExpert(@RequestBody MeetExpertRequest expertsRequest, @RequestHeader("Authorization") String token){
        adminService.addMeetExpert(expertsRequest, token);
    }

    @PostMapping("/addPage2")
    public ResponseEntity<?> addPage2(@RequestBody Page2Request page2Request, @RequestHeader("Authorization") String token){
        adminService.addPage2(page2Request, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @PostMapping("/addCustomers")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerRequest customerRequest, @RequestHeader("Authorization") String token){
        adminService.addCustomer(customerRequest, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @PostMapping("/addCustomersAll")
    public ResponseEntity<?> addCustomerAll(@RequestBody List<CustomerRequest> customerRequest, @RequestHeader("Authorization") String token){
        adminService.addCustomerAll(customerRequest, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @PostMapping("/addPage6")
    public ResponseEntity<?> addPage6(@RequestBody Page6Request page6Requests, @RequestHeader("Authorization") String token){
        adminService.addPage6(page6Requests, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

}
