package com.app.libraryManagementSystem.DTO;

import com.app.libraryManagementSystem.models.Book;

public class BookMapper {

    public static BookDTO mapBookDTO(Book book){

        BookDTO bookDTO = new BookDTO(
        book.getId(),
        book.getTitle(),
        book.getuniqueCode()
        );

        return bookDTO;
    }

    public static Book mapTBook(BookDTO bookDTO){
        Book book = new Book(
            bookDTO.getId(),
            bookDTO.getTitle(),
            bookDTO.getUniqueCode()
        );

        return book;
    } 

}
