package com.library.models;

import java.time.LocalDate;
import java.util.UUID;

public class User {
    String id = UUID.randomUUID().toString();
    String name;
    String email;
    LocalDate bornDate;

    /**********
    * GETTERS 
    ***********/
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    /**********
    * SETTERS 
    ***********/
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }
}
