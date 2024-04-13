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

    @PutMapping("/updatePage2")
    public ResponseEntity<?> updatePage2(@RequestBody Page2Request page2Request, @RequestHeader("Authorization") String token){
        adminService.updatePage2(page2Request, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success\n updates Page2  = {" + page2Request + "}");
    }

    @PostMapping("/addCustomers")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerRequest customerRequest, @RequestHeader("Authorization") String token ){
        adminService.addCustomer(customerRequest, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @PostMapping("/deleteCustomers")
    public ResponseEntity<?> deleteCustomer(@RequestParam("name") String name, @RequestHeader("Authorization") String token){
        adminService.deleteCustomer(name, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerRequestUpdate customerRequest,@RequestHeader("Authorization") String token){
        adminService.updateCustomer(customerRequest, token);

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
    public ResponseEntity<?> addPage6(@RequestBody Page6Request page6Requests, @RequestHeader("Authorization") String token){
        adminService.addPage6(page6Requests, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }
    @PutMapping("/updatePage6")
    public ResponseEntity<?> updatePage6(@RequestBody Page6Request page6Request,@RequestHeader("Authorization") String token){
        adminService.updatePage6(page6Request, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success\n updates Page2  = {" + page6Request + "}");
    }

    @PostMapping("/addAnswer")
    public ResponseEntity<?> addAnswer(@RequestBody AnswerRequest answerRequest, @RequestHeader("Authorization") String token){
        adminService.addAnswer(answerRequest, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @PutMapping("/updateAnswer")
    public ResponseEntity<?> updateAnswer(@RequestBody AnswerRequestUpdate answerRequestUpdate, @RequestHeader("Authorization") String token){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(adminService.updateAnswer(answerRequestUpdate, token));
    }

    @PostMapping("/addPage8")
    public ResponseEntity<?> addPage8(@RequestBody Page8Request page8Request, @RequestHeader("Authorization") String token){
        adminService.addPage8(page8Request, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }
}
