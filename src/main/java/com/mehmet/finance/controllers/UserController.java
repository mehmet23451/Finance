package com.mehmet.finance.controllers;

import com.mehmet.finance.entities.User;
import com.mehmet.finance.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userServiceImpl.createUser(user));
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userServiceImpl.getUserById(id));
    }
}
