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

import com.exemple.bookstore.Adapters.BookRecyclerAdapter;
import com.exemple.bookstore.Contracts.BooksListContract;
import com.exemple.bookstore.Models.Book;
import com.exemple.bookstore.Presenters.BooksListPresenterImp;
import com.exemple.bookstore.R;

import java.util.ArrayList;

/**
 * Created by Jonathan on 06/12/2015.
 */

@SuppressWarnings("unchecked")
public class BooksFragment extends Fragment implements BooksListContract.BooksFragmentView {

    private RecyclerView        booksRecycler;
    private TextView            emptyMessage;

    private BooksListPresenterImp booksFragmentPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books, container, false);

        booksRecycler           = (RecyclerView) view.findViewById(R.id.book_recycler);
        emptyMessage            = (TextView) view.findViewById(R.id.empty_message);

        booksFragmentPresenter = new BooksListPresenterImp();
        booksFragmentPresenter.setView(this);

        if(getArguments() != null){

            Bundle bundle       = getArguments();
            Integer authorId    = bundle.getInt("author_id");

            if(authorId != 0) {
                booksFragmentPresenter.getBooksFromAuthor(authorId);

                TextView bookLabel = (TextView) view.findViewById(R.id.book_label);
                bookLabel.setText(getString(R.string.his_books));
            }

        } else {
            booksFragmentPresenter.getBooks();
        }

        LinearLayoutManager layoutManagerBook = new LinearLayoutManager(getContext());
        layoutManagerBook.setOrientation(LinearLayoutManager.HORIZONTAL);
        booksRecycler.setLayoutManager(layoutManagerBook);

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
}
