package com.handson.firstproject.Controller;

import com.handson.firstproject.entity.User;
import com.handson.firstproject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User createUser(@RequestParam String name) {
        return service.saveUser(name);
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
}
