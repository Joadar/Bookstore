package com.exemple.bookstore.Events;

import com.exemple.bookstore.Models.Book;

import java.util.ArrayList;

/**
 * Created by Jonathan on 05/12/2015.
 */
public class LoadBooksEvent {

    private ArrayList<Book> listBooks;

    public LoadBooksEvent(ArrayList<Book> listBooks) {
        this.listBooks = listBooks;
    }

    public ArrayList<Book> getListBooks(){
        return this.listBooks;
    }
}
