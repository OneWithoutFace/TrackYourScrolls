package com.example.trackyourscrolls;

import java.util.Objects;

public class User {

    private String userName;
    private String password;
    private boolean isAdmin = false;

    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName(){
        return userName;
    }

    public boolean isAdmin(){
        return isAdmin;
    }

    public boolean checkPassword(String inPassword){
        return Objects.equals(inPassword, password);

    }
    public void setAdmin(boolean status){
        this.isAdmin = status;

    }

}
