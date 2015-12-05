package com.exemple.bookstore.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.exemple.bookstore.API.AuthorService;
import com.exemple.bookstore.API.BookService;
import com.exemple.bookstore.API.CommentService;
import com.exemple.bookstore.API.UserService;
import com.exemple.bookstore.Adapters.AuthorRecyclerAdapter;
import com.exemple.bookstore.Adapters.BookRecyclerAdapter;
import com.exemple.bookstore.Adapters.CommentRecyclerAdapter;
import com.exemple.bookstore.Bus.BusProvider;
import com.exemple.bookstore.Events.LoadAuthorsEvent;
import com.exemple.bookstore.Events.LoadBooksEvent;
import com.exemple.bookstore.Events.LoadCommentsEvent;
import com.exemple.bookstore.Models.Author;
import com.exemple.bookstore.Models.Book;
import com.exemple.bookstore.Models.Comment;
import com.exemple.bookstore.Models.User;
import com.exemple.bookstore.R;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView booksRecycler;
    private RecyclerView authorsRecycler;
    private RecyclerView commentsRecycler;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private UserService userService;
    private BookService bookService;
    private AuthorService authorService;
    private CommentService commentService;

    private ArrayList<Book> bookArrayList;
    private BookRecyclerAdapter bookRecyclerAdapter;

    private ArrayList<Author> authorArrayList;
    private AuthorRecyclerAdapter authorRecyclerAdapter;

    private ArrayList<Comment> commentArrayList;
    private CommentRecyclerAdapter commentRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userService = new UserService();
        bookService = new BookService();
        authorService = new AuthorService();
        commentService = new CommentService();

        getBooks();
        getAuthors();
        getComments();

        // books list
        bookArrayList = new ArrayList<Book>();
        bookRecyclerAdapter = new BookRecyclerAdapter(this, bookArrayList);

        LinearLayoutManager layoutManagerBook = new LinearLayoutManager(this);
        layoutManagerBook.setOrientation(LinearLayoutManager.HORIZONTAL);

        booksRecycler = (RecyclerView) findViewById(R.id.book_recycler);
        booksRecycler.setLayoutManager(layoutManagerBook);
        booksRecycler.setAdapter(bookRecyclerAdapter);

        // authors list
        authorArrayList = new ArrayList<Author>();
        authorRecyclerAdapter = new AuthorRecyclerAdapter(this, authorArrayList);

        LinearLayoutManager layoutManagerAuthor = new LinearLayoutManager(this);
        layoutManagerAuthor.setOrientation(LinearLayoutManager.HORIZONTAL);

        authorsRecycler = (RecyclerView) findViewById(R.id.author_recycler);
        authorsRecycler.setLayoutManager(layoutManagerAuthor);
        authorsRecycler.setAdapter(authorRecyclerAdapter);

        // comments list
        commentArrayList = new ArrayList<Comment>();
        commentRecyclerAdapter = new CommentRecyclerAdapter(this, commentArrayList);

        LinearLayoutManager layoutManagerComment = new LinearLayoutManager(this);
        layoutManagerComment.setOrientation(LinearLayoutManager.HORIZONTAL);

        commentsRecycler = (RecyclerView) findViewById(R.id.comment_recycler);
        commentsRecycler.setLayoutManager(layoutManagerComment);
        commentsRecycler.setAdapter(commentRecyclerAdapter);
    }

    private void getComments(){
        commentService.getComments(new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                commentArrayList = (ArrayList<Comment>) response.body();
                Log.d(LOG_TAG, "listComments = " + commentArrayList.get(0).getContent());
                BusProvider.getInstance().post(new LoadCommentsEvent(commentArrayList));
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
                authorArrayList = (ArrayList<Author>) response.body();
                BusProvider.getInstance().post(new LoadAuthorsEvent(authorArrayList));
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
                bookArrayList = (ArrayList<Book>) response.body();
                BusProvider.getInstance().post(new LoadBooksEvent(bookArrayList));
                //Log.d(LOG_TAG, "books 0 author = " + listBooks.get(0).getAuthor().getBiography());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Subscribe
    public void onLoadBooksEvent(LoadBooksEvent event){
        booksRecycler.setAdapter(new BookRecyclerAdapter(this, event.getListBooks()));
    }

    @Subscribe
    public void onLoadAuthorsEvent(LoadAuthorsEvent event){
        authorsRecycler.setAdapter(new AuthorRecyclerAdapter(this, event.getListAuthors()));
    }

    @Subscribe
    public void onLoadCommentsEvent(LoadCommentsEvent event){
        commentsRecycler.setAdapter(new CommentRecyclerAdapter(this, event.getListComments()));
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

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }
}
