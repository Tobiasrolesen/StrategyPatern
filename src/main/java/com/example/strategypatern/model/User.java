package com.example.strategypatern.model;

public class User {
    private String fname;
    private String password;
    private String email;

    public User(String fname, String password, String email){
        this.fname = fname;
        this.password = password;
        this.email = email;
    }

    public String getFname(){
        return fname;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public void setFname(String fname){
        this.fname = fname;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
