package com.exemple.bookstore.Models;

/**
 * Created by Jonathan on 28/11/2015.
 */
public class User {

    private int     id;
    private String  username;
    private String  token;
    private String  email;
    private char    sexe;
    private boolean active;
    private boolean admin;

    public User(int id, String username, String token, String email, char sexe, boolean active, boolean admin) {
        this.id         = id;
        this.username   = username;
        this.token      = token;
        this.email      = email;
        this.sexe       = sexe;
        this.active     = active;
        this.admin      = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
