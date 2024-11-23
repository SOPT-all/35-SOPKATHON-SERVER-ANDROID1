package sopkathon.android1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sopkathon.android1.dto.request.UserCreateRequestDTO;
import sopkathon.android1.dto.response.UserGetResponseDTO;
import sopkathon.android1.service.UserService;

@RestController
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user")
    public ResponseEntity<UserGetResponseDTO> getUser(){
        UserGetResponseDTO user = UserService.getUserInfo();
        return ResponseEntity.ok(user);
    }


    @PostMapping("/api/user")
    public void postUser(@RequestBody UserCreateRequestDTO userCreateRequestDTO){
        userService.createUserInfo(userCreateRequestDTO);
    }


}
