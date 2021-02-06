package com.example.springbootmultitenancy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmultitenancy.domain.UserDomain;
import com.example.springbootmultitenancy.dto.UserRequestBody;
import com.example.springbootmultitenancy.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
 
    private final UserRepository userRepository;
 
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
 
    @PostMapping
    public UserDomain addUser(@RequestBody UserRequestBody userRequestBody) {
        UserDomain userDomain = new UserDomain(userRequestBody.getName());
        return userRepository.save(userDomain);
    }
 
    @GetMapping
    public List<UserDomain> getAll() {
        return userRepository.findAll();
    }
}
