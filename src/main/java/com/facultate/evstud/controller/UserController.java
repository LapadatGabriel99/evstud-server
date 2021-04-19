package com.facultate.evstud.controller;

import com.facultate.evstud.converters.UserConverter;
import com.facultate.evstud.dto.UserDTO;
import com.facultate.evstud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@Valid @RequestBody UserDTO dto) {

        return new ResponseEntity<>(
                userConverter.documentToDto(userService.login(userConverter.dtoToDocument(dto))),
                HttpStatus.OK);
    }
}
