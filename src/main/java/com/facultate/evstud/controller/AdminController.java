package com.facultate.evstud.controller;

import com.facultate.evstud.converters.UserConverter;
import com.facultate.evstud.dto.UserDTO;
import com.facultate.evstud.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1.0/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private AdminService adminService;


    @PostMapping("/create-user")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO dto) {

        return new ResponseEntity<>(
                userConverter.documentToDto(adminService.createUser(userConverter.dtoToDocument(dto))),
                HttpStatus.CREATED);
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        return new ResponseEntity<>(
                userConverter.convertToListOfDto(adminService.getAllUsers()),
                HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all-users/role")
    public ResponseEntity<List<UserDTO>> getAllUsersByRole(@RequestParam("name") String name) {

        return new ResponseEntity<>(
                userConverter.convertToListOfDto(adminService.getAllUsersByRole(name)),
                HttpStatus.ACCEPTED);
    }

    @PutMapping("/update-user")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO dto) {

        return new ResponseEntity<>(
                userConverter.documentToDto(adminService.updateUser(userConverter.dtoToDocument(dto))),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete-user/id")
    public ResponseEntity<String> deleteUser(@RequestParam("id") Long id) {

        adminService.deleteUser(id);

        return new ResponseEntity<>("Used has been deleted", HttpStatus.OK);
    }
}
