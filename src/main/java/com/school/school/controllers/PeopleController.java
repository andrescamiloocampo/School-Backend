package com.school.school.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.school.models.User;
import com.school.school.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/people")
public class PeopleController {
    private final UserRepository userRepository;

    public PeopleController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/list")
    public List<User> getPeople() {
        return this.userRepository.findAll();
    }
    
}
