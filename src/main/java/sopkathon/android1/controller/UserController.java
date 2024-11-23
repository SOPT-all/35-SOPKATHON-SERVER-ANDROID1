package sopkathon.android1.controller;

import org.springframework.web.bind.annotation.RestController;
import sopkathon.android1.service.UserService;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
