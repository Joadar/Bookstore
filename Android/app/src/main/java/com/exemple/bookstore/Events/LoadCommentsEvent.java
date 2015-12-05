package com.exemple.bookstore.Events;

import com.exemple.bookstore.Models.Comment;

import java.util.ArrayList;

/**
 * Created by Jonathan on 05/12/2015.
 */
public class LoadCommentsEvent {

    private ArrayList<Comment> listComments;

    public LoadCommentsEvent(ArrayList<Comment> listComments){
        this.listComments = listComments;
    }

    public ArrayList<Comment> getListComments(){
        return this.listComments;
    }
}
