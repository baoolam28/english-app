package CTTNHH_BaooLam_Group.Practice_English_App_BE.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CTTNHH_BaooLam_Group.Practice_English_App_BE.DataTranferOject.UserDTO.UserSignResponse;
import CTTNHH_BaooLam_Group.Practice_English_App_BE.DataTranferOject.API.ApiResponse;
import CTTNHH_BaooLam_Group.Practice_English_App_BE.DataTranferOject.UserDTO.UserSignRequest;
import CTTNHH_BaooLam_Group.Practice_English_App_BE.Service.UserService;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping()
    public String getUsers() {
        return "hello world";
    }
    

    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(@RequestBody UserSignRequest userSignRequest) {
        try {
            UserSignResponse userSignResponse = userService.createUser(userSignRequest);
            ApiResponse<UserSignResponse> apiRes = new ApiResponse<UserSignResponse>(
                    LocalDateTime.now(),
                    HttpStatus.OK.value(),
                    "User created successfully",
                    userSignResponse);
            return new ResponseEntity(apiRes, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse<UserSignResponse> apiRes = new ApiResponse<UserSignResponse>(
                    LocalDateTime.now(),
                    HttpStatus.BAD_REQUEST.value(),
                    "Server error: " + e.getMessage(),
                    null);
            return new ResponseEntity(apiRes, HttpStatus.BAD_REQUEST);
        }
    }
    
}
