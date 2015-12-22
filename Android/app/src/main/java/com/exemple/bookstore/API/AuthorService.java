package com.exemple.bookstore.API;

import com.exemple.bookstore.Models.Author;

import java.util.List;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Jonathan on 04/12/2015.
 */
public class AuthorService {

    private RestInterface restInterface;

    public AuthorService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestInterface.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restInterface = retrofit.create(RestInterface.class);
    }

    public void getAuthors(Callback<List<Author>> callback){
        restInterface.listAuthors().enqueue(callback);
    }

    public void getAuthorById(int id, Callback<Author> callback){
        restInterface.getAuthor(id).enqueue(callback);
    }

    public void getAuthorsByTitle(String title, Callback<List<Author>> callback){
        restInterface.getAuthorsByTitle(title).enqueue(callback);
    }

    public void getAuthorsByName(String name, Callback<List<Author>> callback){
        restInterface.getAuthorsByName(name).enqueue(callback);
    }

}
