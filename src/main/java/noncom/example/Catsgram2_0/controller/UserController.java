package noncom.example.Catsgram2_0.controller;

import noncom.example.Catsgram2_0.service.UserService;
import noncom.example.Catsgram2_0.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/{login}")
    public Optional<User> getUser(@PathVariable String login) {
        return userService.findUserById(login);
    }
}
