package com.jscreations.myloginapplication;

public class Users {
    String email;
    String username;

    public Users(){};

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Users(String email, String username) {
        this.email = email;
        this.username = username;
    }
}
