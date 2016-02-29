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

import com.exemple.bookstore.Adapters.AuthorRecyclerAdapter;
import com.exemple.bookstore.Contracts.AuthorsListContract;
import com.exemple.bookstore.Models.Author;
import com.exemple.bookstore.Presenters.AuthorsListPresenterImp;
import com.exemple.bookstore.R;
import com.exemple.bookstore.Utils.Tools;

import java.util.ArrayList;

/**
 * Created by Jonathan on 12/12/2015.
 */
@SuppressWarnings("unchecked")
public class AuthorsFragment extends Fragment implements AuthorsListContract.AuthorsView {

    private AuthorRecyclerAdapter   authorRecyclerAdapter;

    private RecyclerView            authorsRecycler;
    private TextView                emptyMessage;

    private AuthorsListPresenterImp authorsListPresenterImp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authors, container, false);

        emptyMessage    = (TextView) view.findViewById(R.id.empty_message);

        authorsListPresenterImp = new AuthorsListPresenterImp();
        authorsListPresenterImp.setView(this);

        authorsListPresenterImp.getAuthors();

        LinearLayoutManager layoutManagerAuthor = new LinearLayoutManager(getContext());
        layoutManagerAuthor.setOrientation(LinearLayoutManager.HORIZONTAL);

        authorsRecycler = (RecyclerView) view.findViewById(R.id.author_recycler);
        authorsRecycler.setLayoutManager(layoutManagerAuthor);
        authorsRecycler.setAdapter(authorRecyclerAdapter);

        if(Tools.readFromPreferences(getContext(), "AuthorPosition", null) != null) {
            int position = Integer.valueOf(Tools.readFromPreferences(getContext(), "AuthorPosition", null));
            authorsRecycler.scrollToPosition(position);
        }

        return view;
    }

    @Override
    public void authorsEmpty(boolean empty) {
        if(empty){
            authorsRecycler.setVisibility(View.GONE);
            emptyMessage.setVisibility(View.VISIBLE);
        } else {
            authorsRecycler.setVisibility(View.VISIBLE);
            emptyMessage.setVisibility(View.GONE);
        }
    }

    @Override
    public void refreshAuthorsList(ArrayList<Author> authorArrayList) {
        authorsRecycler.setAdapter(new AuthorRecyclerAdapter(getContext(), authorArrayList));

    }
}
