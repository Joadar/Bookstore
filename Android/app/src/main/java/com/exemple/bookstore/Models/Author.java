package com.exemple.bookstore.Models;

/**
 * Created by Jonathan on 04/12/2015.
 */
public class Author {

    private int     id;
    private String  firstname;
    private String  lastname;
    private String  biography;
    private String  image;

    public Author(int id, String firstname, String lastname, String biography, String image) {
        this.id         = id;
        this.firstname  = firstname;
        this.lastname   = lastname;
        this.biography  = biography;
        this.image      = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
