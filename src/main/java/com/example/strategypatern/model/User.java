package com.example.strategypatern.model;

import com.example.strategypatern.service.validation.ValidationMode;

public class User {
    private String username;
    private String password;
    private String email;

    public User(String fname, String password, String email) {
        this.username = fname;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
