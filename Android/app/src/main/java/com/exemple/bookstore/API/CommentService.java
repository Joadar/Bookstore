package com.exemple.bookstore.API;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Jonathan on 04/12/2015.
 */
public class CommentService {

    private RestInterface restInterface;

    public CommentService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestInterface.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restInterface = retrofit.create(RestInterface.class);
    }

    public void getCommentsByBook(int bookId, Callback callback){
        restInterface.listCommentsByBook(bookId).enqueue(callback);
    }

    public void getCommentByIdAndByBook(int bookId, int commentId, Callback callback){
        restInterface.getCommentByIdAndByBook(bookId, commentId).enqueue(callback);
    }

}
