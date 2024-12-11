package com.app.libraryManagementSystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.libraryManagementSystem.DTO.BookDTO;
import com.app.libraryManagementSystem.DTO.BookMapper;
import com.app.libraryManagementSystem.exceptions.ResourceNotFoundException;
import com.app.libraryManagementSystem.models.Book;
import com.app.libraryManagementSystem.repository.BookRepository;

import jakarta.transaction.Transactional;

   

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDTO addNewBook(BookDTO bookDTO){
        Book book = BookMapper.mapTBook(bookDTO);

        Book savedBook = bookRepository.save(book);

        return(BookMapper.mapBookDTO(savedBook));
        
    }


    public List<BookDTO>  getAllBooks(BookDTO bookDTO){
        
        List<Book> books = bookRepository.findAll();

       return books.stream()
              .map(BookMapper::mapBookDTO)
              .collect(Collectors.toList());

        
    }

    public BookDTO getBookById(Long id){
        Book book = bookRepository.findById(id).get();

        return (BookMapper.mapBookDTO(book));

       
    }

    public BookDTO getBookByUniqueCode(String uniqueCode) {
        // Fetch book using the unique code
        Book book = bookRepository.findByUniqueCode(uniqueCode)
                                  .orElseThrow(() -> new ResourceNotFoundException("Book not found with code: " + uniqueCode));
    
        return BookMapper.mapBookDTO(book);
    }


    @Transactional 
    public void deleteBookByUniqueCode(String uniqueCode) {
        // Check if the book exists
        Book book = bookRepository.findByUniqueCode(uniqueCode)
                                   .orElseThrow(() -> new ResourceNotFoundException("Book not found with code: " + uniqueCode));

        // Perform the delete operation
        bookRepository.deleteByUniqueCode(uniqueCode);
    }

    
}
