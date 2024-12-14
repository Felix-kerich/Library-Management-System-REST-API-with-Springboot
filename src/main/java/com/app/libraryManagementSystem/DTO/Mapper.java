package com.app.libraryManagementSystem.DTO;

import com.app.libraryManagementSystem.models.User;

public class Mapper {

    public static User mapToUser(UserDTO userDTO){
        User user = new User(
            userDTO.getId(),
            userDTO.getEmail(),
            userDTO.getFullName(),            
            userDTO.getPassword(),
            userDTO.getCreatedAt(),
            userDTO.getUpdatedAt()
                       

        );
        return user;
    }

    public static UserDTO mapToUserDTO(User user){
        UserDTO userDTO = new UserDTO(
            user.getId(),
            user.getEmail(),
            user.getFullName(),            
            user.getPassword(), 
            user.getCreatedAt(),
            user.getUpdatedAt()
                      );
            return userDTO;
    } 

}
