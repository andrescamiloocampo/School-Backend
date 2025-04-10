package com.school.school.dto;

import lombok.Getter;
import lombok.Setter;

public class LoginUserDTO {
    @Getter @Setter private String username;
    @Getter @Setter private String password;
    @Getter @Setter private String rol;

    public LoginUserDTO(){}
}
