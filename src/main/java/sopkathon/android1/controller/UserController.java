package sopkathon.android1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopkathon.android1.dto.request.UserCreateRequestDTO;
import sopkathon.android1.dto.response.AuthInfoResponseDTO;
import sopkathon.android1.dto.response.UserGetResponseDTO;
import sopkathon.android1.dto.response.UserRankingResponseDTO;
import sopkathon.android1.service.UserService;

@RestController
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user")
    public ResponseEntity<UserGetResponseDTO> getUser(){
        UserGetResponseDTO user = userService.getUserInfo();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/api/user")
    public void postUser(@RequestBody UserCreateRequestDTO userCreateRequestDTO){
        userService.createUserInfo(userCreateRequestDTO);
    }

    @GetMapping("/api/auth-info")
    public ResponseEntity<AuthInfoResponseDTO> getAuthInfo() {
        return ResponseEntity.ok(userService.getAuthInfo());
    }

    @GetMapping("/api/ranking")
    public ResponseEntity<UserRankingResponseDTO> getRanking(@RequestParam String part) {
        return ResponseEntity.ok(userService.getRankingInfo(part));
    }

}
