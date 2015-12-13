package com.exemple.bookstore.Events;

/**
 * Created by Jonathan on 13/12/2015.
 */
public class SearchEvent {

    private String search;

    public SearchEvent(String search){
        this.search = search;
    }

    public String getSearch(){
        return this.search;
    }
}
