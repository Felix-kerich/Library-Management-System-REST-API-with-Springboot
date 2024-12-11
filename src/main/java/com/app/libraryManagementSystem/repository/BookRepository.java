package com.app.libraryManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.libraryManagementSystem.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    Optional<Book> findByUniqueCode(String uniqueCode);

    void deleteByUniqueCode(String uniqueCode);



}
