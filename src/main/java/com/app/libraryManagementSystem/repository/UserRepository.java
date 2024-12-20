package com.app.libraryManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.libraryManagementSystem.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{    

    
    Optional<User> findByEmail(String email);


}
