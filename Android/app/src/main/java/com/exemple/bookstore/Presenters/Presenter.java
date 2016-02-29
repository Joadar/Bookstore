package com.exemple.bookstore.Presenters;


import com.exemple.bookstore.Views.View;

/**
 * Created by Jonathan on 29/02/2016.
 */
public interface Presenter<T extends View> {

    void setView(T view);

}
