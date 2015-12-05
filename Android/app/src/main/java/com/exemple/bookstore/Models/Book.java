package com.exemple.bookstore.Models;

/**
 * Created by Jonathan on 04/12/2015.
 */
public class Book {

    private int     id;
    private String  title;
    private Author  author;
    private String  description;
    private String  editor;
    private String  collection;
    private int     pages;
    private String  published;
    private String  genre;
    private String  image;

    public Book(int id, String title, Author author, String description, String editor, String collection, int pages, String published, String genre, String image) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.editor = editor;
        this.collection = collection;
        this.pages = pages;
        this.published = published;
        this.genre = genre;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
