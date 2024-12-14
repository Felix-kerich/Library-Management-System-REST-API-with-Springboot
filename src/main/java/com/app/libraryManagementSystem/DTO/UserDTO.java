package com.app.libraryManagementSystem.DTO;

import java.util.Date;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
   
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    private String fullName;    
    private String password;
    private Date createdAt;
    private Date updatedAt;


}
