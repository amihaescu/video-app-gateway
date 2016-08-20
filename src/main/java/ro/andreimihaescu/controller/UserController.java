package ro.andreimihaescu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.andreimihaescu.dto.UserRequest;
import ro.andreimihaescu.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody UserRequest userRequest) {
        return userService.authenticateUser(userRequest.getUsername(), userRequest.getPassword());
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String create(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    private String check(@RequestBody String hash) {
        return userService.checkUser(hash);
    }
}
