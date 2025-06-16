package com.school.school.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class User {
    private String id;
    private String username;
    private String rol;        
}
