package com.exemple.bookstore.API;

import com.exemple.bookstore.Models.Author;
import com.exemple.bookstore.Models.Book;
import com.exemple.bookstore.Models.Comment;
import com.exemple.bookstore.Models.User;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by Jonathan on 28/11/2015.
 */
public interface RestInterface {

    //String ENDPOINT = "http://api.bookstore.dev";
    //String ENDPOINT = "http://10.0.3.2/Projects/Bookstore/API";
    //String ENDPOINT = "http://192.168.0.12:80/Projects/Bookstore/API";
    //String ENDPOINT = "http://192.168.56.1/Projects/Bookstore/API";
    //String ENDPOINT = "http://192.168.0.23";
    String ENDPOINT = "http://192.168.1.27";


    /**
     * USERS
     */

    @POST("/users")
    Call<User> createUser(
        @Body User user
    );

    @POST("/users/login")
    Call<User> authUser(
        @Body User user
    );

    @PUT("/users/{id}")
    Call<User> updateUser(
        @Body User user
    );

    @GET("/users")
    Call<List<User>> listUsers();

    @GET("/users/{id}")
    Call<User> getUser(
        @Path("id") int id
    );

    @GET("/users/{id}/comments")
    Call<List<Comment>> getCommentsByUser(
      @Path("id") int id
    );


    /**
     * BOOKS
     */

    @GET("/books")
    Call<List<Book>> listBooks();

    @GET("/books/{id}")
    Call<Book> getBook(
        @Path("id") int id
    );

    @GET("/books/title/{title}")
    Call<List<Book>> getBooksByTitle(
        @Path("title") String title
    );

    @PUT("/books/{id}")
    Call<Book> updateBook(
        @Path("id") int id,
        @Body Book book
    );


    /**
     * AUTHORS
     */

    @POST("/authors")
    Call<Author> createAuthor(
        @Body Author author
    );

    @PUT("/authors/{id}")
    Call<Author> updateAuthor(
        @Path("id") int id,
        @Body Author author
    );

    @GET("/authors")
    Call<List<Author>> listAuthors();

    @GET("/authors/{id}")
    Call<Author> getAuthor(
        @Path("id") int id
    );

    @GET("/authors/{id}/books")
    Call<List<Book>> getBooksByAuthor(
        @Path("id") int id
    );

    @GET("/authors/book_title/{title}")
    Call<List<Author>> getAuthorsByTitle(
        @Path("title") String title
    );

    @GET("/authors/name/{name}")
    Call<List<Author>> getAuthorsByName(
        @Path("name") String name
    );

    @POST("/authors/{id}/books")
    Call<Book> createBook(
        @Path("id") int id,
        @Body Book book
    );


    /**
     * COMMENTS
     */

    @GET("/comments")
    Call<List<Comment>> listComments();

    @GET("/books/{id}/comments")
    Call<List<Comment>> listCommentsByBook(
        @Path("id") int id
    );

    @GET("/books/{bid}/comments/{cid}")
    Call<Comment> getCommentByIdAndByBook(
        @Path("bid") int bid,
        @Path("cid") int cid
    );

    @POST("/books/{id}/comments")
    Call<Comment> createComment(
        @Path("id") int id,
        @Body Comment comment
    );

    @PUT("/books/{id}/comments")
    Call<Comment> updateComment(
        @Path("id") int id,
        @Body Comment comment
    );

}
