package com.msua.user.controller;

import com.msua.user.entity.User;
import com.msua.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/saveuser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/fetchallusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable String userId){
        return userService.getUser(userId);
    }
}
