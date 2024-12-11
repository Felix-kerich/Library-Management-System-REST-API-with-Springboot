package com.app.libraryManagementSystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.libraryManagementSystem.DTO.BookDTO;
import com.app.libraryManagementSystem.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping
    public ResponseEntity<BookDTO> addNewBook(@RequestBody BookDTO bookDTO){
        BookDTO savedBook = bookService.addNewBook(bookDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);

    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(BookDTO bookDTO) {
       List<BookDTO> books = bookService.getAllBooks(bookDTO);

       return ResponseEntity.ok(books);


    }

    @GetMapping("/{uniqueCode}")
    public ResponseEntity<BookDTO> getBookByUniqueCode(@PathVariable String uniqueCode) {
        return ResponseEntity.ok(bookService.getBookByUniqueCode(uniqueCode));
    }

    @DeleteMapping("/{uniqueCode}")
    public ResponseEntity<Void> deleteBookByUniqueCode(@PathVariable String uniqueCode) {
    bookService.deleteBookByUniqueCode(uniqueCode);
    return ResponseEntity.noContent().build(); // 204 No Content
}


    @GetMapping("/id/{id}")
    public BookDTO getBookById(@PathVariable Long id){
       return bookService.getBookById(id);
    }

    

}
