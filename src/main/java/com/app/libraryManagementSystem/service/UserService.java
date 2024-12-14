package com.app.libraryManagementSystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.libraryManagementSystem.DTO.Mapper;
import com.app.libraryManagementSystem.DTO.UserDTO;
import com.app.libraryManagementSystem.models.User;
import com.app.libraryManagementSystem.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public UserDTO registerUser(UserDTO userDTO) {
        // Check if the email already exists
        userRepository.findByEmail(userDTO.getEmail()).ifPresent(existingUser -> {
            throw new IllegalArgumentException("User with email " + userDTO.getEmail() + " already available. Use another email or login.");
        });
    
        // Proceed with registration
        User user = Mapper.mapToUser(userDTO);
    
        User savedUser = userRepository.save(user);
    
        return Mapper.mapToUserDTO(savedUser);
    }
    

    public List<UserDTO> getAllUsers(UserDTO userDTO){
       
        List<User> users = userRepository.findAll();

        return users.stream().map(Mapper::mapToUserDTO).collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserById(Long id){
       Optional<User> user = userRepository.findById(id);
       
       return user.stream().map(Mapper::mapToUserDTO).findAny();

    }

    public String deleteUser(Long id){
       userRepository.deleteById(id);

       return ("user deleted successfully");
    }

}
