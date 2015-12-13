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

import com.exemple.bookstore.API.AuthorService;
import com.exemple.bookstore.Adapters.AuthorRecyclerAdapter;
import com.exemple.bookstore.Bus.BusProvider;
import com.exemple.bookstore.Events.LoadAuthorsEvent;
import com.exemple.bookstore.Events.SearchEvent;
import com.exemple.bookstore.Models.Author;
import com.exemple.bookstore.R;
import com.exemple.bookstore.Utils.Tools;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Jonathan on 12/12/2015.
 */
public class AuthorsFragment extends Fragment {

    private AuthorService           authorService;

    private ArrayList<Author>       authorArrayList;
    private AuthorRecyclerAdapter   authorRecyclerAdapter;

    private RecyclerView            authorsRecycler;
    private TextView                emptyMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authors, container, false);

        authorService   = new AuthorService();
        emptyMessage    = (TextView) view.findViewById(R.id.empty_message);

        getAuthors();

        // authors list
        authorArrayList = new ArrayList<Author>();
        authorRecyclerAdapter = new AuthorRecyclerAdapter(getContext(), authorArrayList);

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

    private void authorsOrNot(ArrayList<Author> authors){
        if(authors.size() == 0){
            authorsRecycler.setVisibility(View.GONE);
            emptyMessage.setVisibility(View.VISIBLE);
        } else {
            authorsRecycler.setVisibility(View.VISIBLE);
            emptyMessage.setVisibility(View.GONE);
        }
    }

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

    private void getAuthors(){
        authorService.getAuthors(new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                authorArrayList = (ArrayList<Author>) response.body();
                BusProvider.getInstance().post(new LoadAuthorsEvent(authorArrayList));
                authorsOrNot(authorArrayList);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void searchAuthors(String search){
        authorService.getAuthorsByName(search, new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                authorArrayList = (ArrayList<Author>) response.body();
                BusProvider.getInstance().post(new LoadAuthorsEvent(authorArrayList));
                authorsOrNot(authorArrayList);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Subscribe
    public void onLoadAuthorsEvent(LoadAuthorsEvent event){
        authorsRecycler.setAdapter(new AuthorRecyclerAdapter(getContext(), event.getListAuthors()));
    }

    @Subscribe
    public void onSearchEvent(SearchEvent event){
        if(event.getSearch() != null){
            searchAuthors(event.getSearch());
        } else {
            getAuthors();
        }
    }
}
