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
import com.exemple.bookstore.Contracts.BooksFragmentContract;
import com.exemple.bookstore.Models.Book;
import com.exemple.bookstore.Presenters.BooksFragmentPresenter;
import com.exemple.bookstore.R;

import java.util.ArrayList;

/**
 * Created by Jonathan on 06/12/2015.
 */

@SuppressWarnings("unchecked")
public class BooksFragment extends Fragment implements BooksFragmentContract.View {

    private BookService         bookService;
    private RecyclerView        booksRecycler;

    //private ArrayList<Book>     bookArrayList;
    private BookRecyclerAdapter bookRecyclerAdapter;

    private TextView            emptyMessage;

    private BooksFragmentContract.Presenter booksFragmentPresenter;

    @Override
    public void onResume() {
        super.onResume();
        //BusProvider.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        //BusProvider.getInstance().unregister(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books, container, false);

        booksRecycler   = (RecyclerView) view.findViewById(R.id.book_recycler);
        emptyMessage    = (TextView) view.findViewById(R.id.empty_message);

        bookService     = new BookService();

        booksFragmentPresenter = new BooksFragmentPresenter(this);

        if(getArguments() != null){

            Bundle bundle = getArguments();
            Integer authorId = bundle.getInt("author_id");

            if(authorId != 0) {
                booksFragmentPresenter.getBooksFromAuthor(authorId);


                TextView bookLabel = (TextView) view.findViewById(R.id.book_label);
                bookLabel.setText(getString(R.string.his_books));
            }

        } else {
            booksFragmentPresenter.getBooks();
        }

        // books list
        //bookArrayList = new ArrayList<>();
        //bookRecyclerAdapter = new BookRecyclerAdapter(getContext(), bookArrayList);

        LinearLayoutManager layoutManagerBook = new LinearLayoutManager(getContext());
        layoutManagerBook.setOrientation(LinearLayoutManager.HORIZONTAL);

        booksRecycler.setLayoutManager(layoutManagerBook);
        booksRecycler.setAdapter(bookRecyclerAdapter);

        return view;
    }

    @Override
    public void booksEmpty(Boolean empty) {
        if(empty){
            booksRecycler.setVisibility(View.GONE);
            emptyMessage.setVisibility(View.VISIBLE);
        } else {
            booksRecycler.setVisibility(View.VISIBLE);
            emptyMessage.setVisibility(View.GONE);
        }
    }

    @Override
    public void refreshBooksList(ArrayList<Book> bookArrayList) {
        booksRecycler.setAdapter(new BookRecyclerAdapter(getContext(), bookArrayList));
    }

    /*@Subscribe
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
    }*/
}
