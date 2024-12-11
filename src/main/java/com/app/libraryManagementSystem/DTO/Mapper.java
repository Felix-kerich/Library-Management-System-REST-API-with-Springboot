package com.app.libraryManagementSystem.DTO;

import com.app.libraryManagementSystem.models.User;

public class Mapper {

    public static User mapToUser(UserDTO userDTO){
        User user = new User(
            userDTO.getId(),
            userDTO.getFullName(),
            userDTO.getEmail(),
            userDTO.getPassword()
                       

        );
        return user;
    }

    public static UserDTO mapToUserDTO(User user){
        UserDTO userDTO = new UserDTO(
            user.getId(),
            user.getFullName(),
            user.getEmail(),
            user.getPassword() 
                      );
            return userDTO;
    } 

}
