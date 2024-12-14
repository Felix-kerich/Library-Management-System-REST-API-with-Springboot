package com.app.libraryManagementSystem.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class BookDTO {
    private Long id;
    private String title;
    @Column(unique = true, nullable = false)
    private String uniqueCode;
    private String author;

}
