package com.school.school.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.school.dto.LoginUserDTO;
import com.school.school.services.FlaskService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    FlaskService flaskService;

    @PostMapping("login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody LoginUserDTO user) {
        Map<String, Object> response = new HashMap<>();
        try {
            String token = flaskService.loginAndGetToken(user.getUsername(), user.getPassword());
            response.put("success", true);
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "Error: Unable to login");
            return ResponseEntity.status(500).body(response);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody LoginUserDTO user) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean status = flaskService.registerUser(user.getUsername(), user.getPassword(), user.getRol());
            response.put("success", status);

            if (status) {
                response.put("message", "User created");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "User already exists or could not be created");
                return ResponseEntity.status(409).body(response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "Error: Unable to register");
            return ResponseEntity.status(500).body(response);
        }
    }

}
