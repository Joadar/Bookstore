package com.exemple.bookstore.API;

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

    public void getBooks(Callback callback){ restInterface.listBooks().enqueue(callback); }

    public void getBookById(int id, Callback callback){
        restInterface.getBook(id).enqueue(callback);
    }

    public void getBooksByAuthor(int id, Callback callback){
        restInterface.getBooksByAuthor(id).enqueue(callback);
    }

}
