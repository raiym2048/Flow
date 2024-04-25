package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.dto.*;
import kg.it_lab.backend.Flow.entities.User;
import kg.it_lab.backend.Flow.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)

public class AdminController {
    private final AdminService adminService;

    @GetMapping("/users")
    List<User> users(@RequestHeader(value = "Authorization", required = false) String token){
        return adminService.getAllUsers(token);
    }

    @PostMapping("/addExpert")
    public void addExpert(@RequestBody ExpertsRequest expertsRequest, @RequestHeader("Authorization") String token ){
        adminService.addExpert(expertsRequest, token);
    }

    @PostMapping("/deleteExpert")
    public ResponseEntity<?> deleteExpert(@RequestParam("name") String name, @RequestHeader("Authorization") String token){
        adminService.deleteExpert(name, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success delete Expert by name is: " + name);
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

    @PostMapping("/addBodyPage2")
    public ResponseEntity<?> addBodyPage2(@RequestBody BodyPage2Dto bodyPage2Dto, @RequestHeader("Authorization") String token){
        adminService.addBodyPage2(bodyPage2Dto, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @PostMapping("/addPage3")
    public ResponseEntity<?> addPage3(@RequestBody Page3Request page3Request, @RequestHeader("Authorization") String token){
        adminService.addPage3(page3Request, token);

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

    @PostMapping("/addBlog")
    public ResponseEntity<?> addBlog(@RequestBody BlogRequest blogRequest, @RequestHeader("Authorization") String token){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(adminService.addBlog(blogRequest, token));
    }

    @PutMapping("/deleteBlog")
    public ResponseEntity<?> deleteBlog(@RequestBody BlogRequest blogRequest, @RequestHeader("Authorization") String token){
        adminService.deleteBlog(blogRequest, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success\n Delete Blog = {" + blogRequest + "}");
    }

    @PutMapping("/updateBlog")
    public ResponseEntity<?> updateBlog(@RequestBody BlogRequestUpdate blogRequestUpdate, @RequestHeader("Authorization") String token){
        adminService.updateBlog(blogRequestUpdate, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @PostMapping("/addPage9")
    public ResponseEntity<?> addPage9(@RequestBody Page9Request page9Request, @RequestHeader("Authorization") String token){
        adminService.addPage9(page9Request, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }
    @PostMapping("/addStartPageData")
    public void addStartPageData(@RequestBody StartPageRequest startPageRequest, @RequestHeader("Authorization") String token) {
        adminService.addStartPageData(startPageRequest, token);
    }

    @PostMapping("/addPage7")
    public void addPage7(@RequestBody Page7Request page7Request, @RequestHeader("Authorization") String token) {
        adminService.addPage7Data(page7Request, token);
    }

    @PostMapping("/addPage4")
    public void addPage4(@RequestBody Page4Request page4Request, @RequestHeader("Authorization") String token){
        adminService.addPage4Data(page4Request, token);
    }

    @PostMapping("/addPage11")
    public ResponseEntity<?> addPage11(@RequestBody Page11Dto page11Dto, @RequestHeader("Authorization") String token){
        adminService.addPage11(page11Dto, token);

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

}
