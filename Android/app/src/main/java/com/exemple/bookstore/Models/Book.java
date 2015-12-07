package com.exemple.bookstore.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jonathan on 04/12/2015.
 */
public class Book implements Parcelable {

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

    protected Book(Parcel in) {
        id = in.readInt();
        title = in.readString();
        author = in.readParcelable(Author.class.getClassLoader());
        description = in.readString();
        editor = in.readString();
        collection = in.readString();
        pages = in.readInt();
        published = in.readString();
        genre = in.readString();
        image = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeParcelable(author, flags);
        dest.writeString(description);
        dest.writeString(editor);
        dest.writeString(collection);
        dest.writeInt(pages);
        dest.writeString(published);
        dest.writeString(genre);
        dest.writeString(image);
    }
}
