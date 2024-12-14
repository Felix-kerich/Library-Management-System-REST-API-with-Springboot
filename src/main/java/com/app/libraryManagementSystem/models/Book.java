package com.app.libraryManagementSystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(unique = true, nullable = false)
    private String uniqueCode;
    private String author;

    

    public Book() {
    }

    public Book(Long id, String title, String uniqueCode, String author) {
        this.id = id;
        this.title = title;
        this.uniqueCode = uniqueCode;
        this.author = author;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUniqueCode() {
        return this.uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book id(Long id) {
        setId(id);
        return this;
    }

    public Book title(String title) {
        setTitle(title);
        return this;
    }

    public Book uniqueCode(String uniqueCode) {
        setUniqueCode(uniqueCode);
        return this;
    }

    public Book author(String author) {
        setAuthor(author);
        return this;
    }

    
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", uniqueCode='" + getUniqueCode() + "'" +
            ", author='" + getAuthor() + "'" +
            "}";
    }
    

}
