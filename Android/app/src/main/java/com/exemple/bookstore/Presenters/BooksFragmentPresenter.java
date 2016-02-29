package com.exemple.bookstore.Presenters;

import com.exemple.bookstore.API.BookService;
import com.exemple.bookstore.Contracts.BooksFragmentContract;
import com.exemple.bookstore.Models.Book;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Jonathan on 28/02/2016.
 */
public class BooksFragmentPresenter implements BooksFragmentContract.Presenter {

    private ArrayList<Book> bookArrayList;
    private BookService     bookService;

    private BooksFragmentContract.View booksFragmentView;

    public BooksFragmentPresenter(BooksFragmentContract.View booksFragmentView){
        this.booksFragmentView = booksFragmentView;

        bookArrayList = new ArrayList<Book>();
        bookService = new BookService();
    }

    @Override
    public void getBooks(){
        bookService.getBooks(new Callback<List<Book>>() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                bookArrayList = (ArrayList<Book>) response.body();
                booksFragmentView.refreshBooksList(bookArrayList);
                booksOrNot(bookArrayList);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    public void getBooksFromAuthor(int id){
        bookService.getBooksByAuthor(id, new Callback<List<Book>>() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                bookArrayList = (ArrayList<Book>) response.body();
                booksFragmentView.refreshBooksList(bookArrayList);
                booksOrNot(bookArrayList);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    public void searchBooks(String title){
        bookService.searchBooks(title, new Callback<List<Book>>() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                bookArrayList = (ArrayList<Book>) response.body();
                booksFragmentView.refreshBooksList(bookArrayList);
                booksOrNot(bookArrayList);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void booksOrNot(ArrayList<Book> books){
        boolean empty = false;
        if(books.size() == 0) {
            empty = true;
        }

        booksFragmentView.booksEmpty(empty);
    }

}
