package com.school.school.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Document(collection = "users")
public class User {
    @Id @Getter @Setter private String id;
    @Getter @Setter private String username;
    @Getter @Setter private String rol;

    public User(){}

    public User(String id,String username,String rol) {
        this.id = id;
        this.username = username;        
        this.rol = rol;
    }
    
}
