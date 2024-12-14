package com.app.libraryManagementSystem.models;


import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(unique = false, name = "full_name")
    private String fullName;
    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;



    public User() {
    }

    public User(Long id, String email, String fullName, String password, Date createdAt, Date updatedAt) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User id(Long id) {
        setId(id);
        return this;
    }

    public User email(String email) {
        setEmail(email);
        return this;
    }

    public User fullName(String fullName) {
        setFullName(fullName);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User createdAt(Date createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public User updatedAt(Date updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

   

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", email='" + getEmail() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", password='" + getPassword() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
    



}
