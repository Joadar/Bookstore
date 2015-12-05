package com.exemple.bookstore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.exemple.bookstore.API.AuthorService;
import com.exemple.bookstore.API.BookService;
import com.exemple.bookstore.API.CommentService;
import com.exemple.bookstore.API.UserService;
import com.exemple.bookstore.Models.Author;
import com.exemple.bookstore.Models.Book;
import com.exemple.bookstore.Models.Comment;
import com.exemple.bookstore.Models.User;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private UserService userService;
    private BookService bookService;
    private AuthorService authorService;
    private CommentService commentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userService = new UserService();
        bookService = new BookService();
        authorService = new AuthorService();
        commentService = new CommentService();

        //getUsers();
        getBooks();
        //getBookById(1);
        //getCommentsByBook(9);
        //getAuthors();
    }

    private void getCommentsByBook(int id){
        commentService.getCommentsByBook(id, new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                List<Comment> listComments = (List<Comment>) response.body();
                Log.d(LOG_TAG, "comments 0 == " + listComments.get(0).getBook().getAuthor().getFirstname());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void getAuthors(){
        authorService.getAuthors(new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                List<Author> listAuthors = (List<Author>) response.body();
                Log.d(LOG_TAG, "authors 0 author = " + listAuthors.get(0).getFirstname());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void getBookById(int id){
        bookService.getBookById(id, new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                Book aBook = (Book) response.body();
                Log.d(LOG_TAG, "book 0 author = " + aBook.getAuthor().getFirstname());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void getBooks(){
        bookService.getBooks(new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                List<Book> listBooks = (List<Book>) response.body();
                Log.d(LOG_TAG, "books 0 author = " + listBooks.get(0).getAuthor().getBiography());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void getUsers(){
        userService.getUsers(new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {

                List<User> listUsers = (List<User>) response.body();

                Log.d(LOG_TAG, "listUsers = " + listUsers.get(0).getUsername());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
