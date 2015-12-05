package com.exemple.bookstore.Models;

/**
 * Created by Jonathan on 04/12/2015.
 */
public class Comment {

    private int     id;
    private User    user;
    private Book    book;
    private String  content;
    private int     rating;
    private String  created;

    public Comment(int id, User user, Book book, String content, int rating, String created) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.content = content;
        this.rating = rating;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() { return rating; }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
