package ro.andreimihaescu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.andreimihaescu.dto.StringResponse;
import ro.andreimihaescu.dto.UserRequest;
import ro.andreimihaescu.service.RoleService;
import ro.andreimihaescu.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public StringResponse login(@RequestBody UserRequest userRequest) {
        return new StringResponse(userService.authenticateUser(userRequest));
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public StringResponse create(@RequestBody UserRequest userRequest) {
        return new StringResponse(userService.createUser(userRequest));
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    private String check(@RequestBody String hash) {
        return userService.checkUser(hash);
    }
}
