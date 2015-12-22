package com.exemple.bookstore.API;

import com.exemple.bookstore.Models.Book;

import java.util.List;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Jonathan on 04/12/2015.
 */
public class BookService {

    private RestInterface restInterface;

    public BookService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestInterface.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restInterface = retrofit.create(RestInterface.class);
    }

    public void getBooks(Callback<List<Book>> callback){ restInterface.listBooks().enqueue(callback); }

    public void getBookById(int id, Callback<Book> callback){
        restInterface.getBook(id).enqueue(callback);
    }

    public void getBooksByAuthor(int id, Callback<List<Book>> callback){
        restInterface.getBooksByAuthor(id).enqueue(callback);
    }

    public void searchBooks(String title, Callback<List<Book>> callback){
        restInterface.getBooksByTitle(title).enqueue(callback);
    }

}
