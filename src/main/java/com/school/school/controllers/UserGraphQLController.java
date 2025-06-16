package com.school.school.controllers;

import java.util.List;

import com.school.school.models.User;
import com.school.school.repositories.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserGraphQLController {
    private final UserRepository userRepository;

    public UserGraphQLController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    
    public User userById(@Argument String id) {
        return userRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @MutationMapping
    public User createUser(@Argument String username, @Argument String rol) {
        User user = new User();
        user.setUsername(username);
        user.setRol(rol);
        return userRepository.save(user);
    }
    
}
