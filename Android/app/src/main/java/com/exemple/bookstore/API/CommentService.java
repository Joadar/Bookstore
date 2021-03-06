package com.exemple.bookstore.API;

import com.exemple.bookstore.Models.Comment;

import java.util.List;

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

    public void getComments(Callback<List<Comment>> callback){
        restInterface.listComments().enqueue(callback);
    }

    public void getCommentsByBook(int bookId, Callback<List<Comment>> callback){
        restInterface.listCommentsByBook(bookId).enqueue(callback);
    }

    public void getCommentByIdAndByBook(int bookId, int commentId, Callback<Comment> callback){
        restInterface.getCommentByIdAndByBook(bookId, commentId).enqueue(callback);
    }

    public void getCommentsByBookTitle(String title, Callback<List<Comment>> callback){
        restInterface.listCommentsByBookTitle(title).enqueue(callback);
    }

}
