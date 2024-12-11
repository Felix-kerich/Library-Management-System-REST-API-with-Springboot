package com.app.libraryManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.libraryManagementSystem.DTO.UserDTO;
import com.app.libraryManagementSystem.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;



    public UserController(UserService userService) {
        this.userService = userService;
    }    



    @PostMapping
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
       UserDTO savedUser = userService.registerUser(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);


    }

    @GetMapping
    public List<UserDTO> getAllUsers(UserDTO userDTO){
       return userService.getAllUsers(userDTO);
    }

   
    @GetMapping("/{id}")
    public Optional<UserDTO> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) 
    {
        userService.deleteUser(id);

        return ("user deleted successfully");
    }

}
