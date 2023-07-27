package com.msua.user.service;

import com.msua.user.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUser(String userId);
    ResponseEntity<String> deleteUser(String userId);
    ResponseEntity<String> updateUser(String userId);
}
