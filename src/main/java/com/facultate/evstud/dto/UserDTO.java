package com.facultate.evstud.dto;

import com.facultate.evstud.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String firstname;

    private String lastname;

    private int phone;

    private int age;

    private Role role;
}
