package com.app.libraryManagementSystem.exceptions;

import org.springframework.http.HttpStatus; // Ensure this is imported
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Maps exception to a 404 response
public class ResourceNotFoundException extends RuntimeException {

    // Constructor to pass custom error messages
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
