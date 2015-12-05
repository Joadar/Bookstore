package com.exemple.bookstore.Events;

import com.exemple.bookstore.Models.Author;

import java.util.ArrayList;

/**
 * Created by Jonathan on 05/12/2015.
 */
public class LoadAuthorsEvent {

    private ArrayList<Author> listAuthors;

    public LoadAuthorsEvent(ArrayList<Author> listAuthors){
        this.listAuthors = listAuthors;
    }

    public ArrayList<Author> getListAuthors(){
        return this.listAuthors;
    }
}
