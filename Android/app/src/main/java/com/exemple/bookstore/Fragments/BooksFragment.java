package com.exemple.bookstore.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exemple.bookstore.API.BookService;
import com.exemple.bookstore.Adapters.BookRecyclerAdapter;
import com.exemple.bookstore.Bus.BusProvider;
import com.exemple.bookstore.Events.LoadBooksEvent;
import com.exemple.bookstore.Events.SearchEvent;
import com.exemple.bookstore.Models.Book;
import com.exemple.bookstore.R;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Jonathan on 06/12/2015.
 */
public class BooksFragment extends Fragment {

    private BookService bookService;
    private RecyclerView booksRecycler;

    private ArrayList<Book> bookArrayList;
    private BookRecyclerAdapter bookRecyclerAdapter;

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books, container, false);

        bookService = new BookService();

        if(getArguments() != null){

            Bundle bundle = getArguments();
            Integer authorId = bundle.getInt("author_id");

            if(authorId != 0) {
                getBooksFromAuthor(authorId);

                TextView bookLabel = (TextView) view.findViewById(R.id.book_label);
                bookLabel.setText(getString(R.string.his_books));
            }

        } else {
            getBooks();
        }

        // books list
        bookArrayList = new ArrayList<Book>();
        bookRecyclerAdapter = new BookRecyclerAdapter(getContext(), bookArrayList);

        LinearLayoutManager layoutManagerBook = new LinearLayoutManager(getContext());
        layoutManagerBook.setOrientation(LinearLayoutManager.HORIZONTAL);

        booksRecycler = (RecyclerView) view.findViewById(R.id.book_recycler);
        booksRecycler.setLayoutManager(layoutManagerBook);
        booksRecycler.setAdapter(bookRecyclerAdapter);

        return view;
    }

    private void getBooks(){
        bookService.getBooks(new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                bookArrayList = (ArrayList<Book>) response.body();
                BusProvider.getInstance().post(new LoadBooksEvent(bookArrayList));
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void getBooksFromAuthor(int id){
        bookService.getBooksByAuthor(id, new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                bookArrayList = (ArrayList<Book>) response.body();
                BusProvider.getInstance().post(new LoadBooksEvent(bookArrayList));
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void searchBooks(String title){
        bookService.searchBooks(title, new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
               bookArrayList = (ArrayList<Book>) response.body();
                BusProvider.getInstance().post(new LoadBooksEvent(bookArrayList));
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Subscribe
    public void onLoadBooksEvent(LoadBooksEvent event){
        booksRecycler.setAdapter(new BookRecyclerAdapter(getContext(), event.getListBooks()));
    }

    @Subscribe
    public void onSearchEvent(SearchEvent event){
        if(event.getSearch() != null){
            searchBooks(event.getSearch());
        } else {
            getBooks();
        }
    }
}
