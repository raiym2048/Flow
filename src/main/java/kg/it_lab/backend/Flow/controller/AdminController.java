package kg.it_lab.backend.Flow.controller;

import kg.it_lab.backend.Flow.dto.ExpertsRequest;
import kg.it_lab.backend.Flow.dto.MeetExpertRequest;
import kg.it_lab.backend.Flow.dto.Page7Request;
import kg.it_lab.backend.Flow.dto.StartPageRequest;
import kg.it_lab.backend.Flow.entities.User;
import kg.it_lab.backend.Flow.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addStartPageData")
    public void addStartPageData(@RequestBody StartPageRequest startPageRequest,
            @RequestHeader("Authorization") String token) {
        adminService.addStartPageData(startPageRequest, token);
    }

    @PostMapping("/addPage7")
    public void addPage7(@RequestBody Page7Request page7Request,
                         @RequestHeader("Authorization") String token) {
        adminService.addPage7Data(page7Request, token);
    }

}
