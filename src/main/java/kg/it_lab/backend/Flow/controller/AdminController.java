package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.dto.*;
import kg.it_lab.backend.Flow.entities.User;
import kg.it_lab.backend.Flow.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
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
    public ResponseEntity<?> addCustomer(@RequestBody CustomerRequest customerRequest){
        adminService.addCustomer(customerRequest);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @PostMapping("/deleteCustomers")
    public ResponseEntity<?> deleteCustomer(@RequestParam("name") String name){
        adminService.deleteCustomer(name);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @PutMapping("/updateCustomers")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerRequestUpdate customerRequest){
        adminService.updateCustomer(customerRequest);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success\n Customer is name = " + customerRequest.getNameDelete() + "update to Customer" + customerRequest.getNameUpdate());
    }

    @PostMapping("/addCustomersAll")
    public ResponseEntity<?> addCustomerAll(@RequestBody List<CustomerRequest> customerRequest, @RequestHeader("Authorization") String token){
        adminService.addCustomerAll(customerRequest, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @PostMapping("/addPage6")
    public ResponseEntity<?> addPage6(@RequestBody Page6Request page6Requests, String token){
        adminService.addPage6(page6Requests, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @PostMapping("/addAnswer")
    public ResponseEntity<?> addAnswer(@RequestBody AnswerRequest answerRequest, String token){
        adminService.addAnswer(answerRequest, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @PostMapping("/addPage8")
    public ResponseEntity<?> addPage8(@RequestBody Page8Request page8Request, String token){
        adminService.addPage8(page8Request, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

}
