package com.exemple.bookstore.Presenters;

import com.exemple.bookstore.API.AuthorService;
import com.exemple.bookstore.Contracts.AuthorsListContract;
import com.exemple.bookstore.Models.Author;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Jonathan on 29/02/2016.
 */
public class AuthorsListPresenterImp implements AuthorsListContract.AuthorsPresenter {

    private AuthorsListContract.AuthorsView authorsView;

    private AuthorService       authorService;
    private ArrayList<Author>   authorArrayList;


    public AuthorsListPresenterImp() {
        authorService   = new AuthorService();
        authorArrayList = new ArrayList<>();
    }

    @Override
    public void getAuthors() {
        authorService.getAuthors(new Callback<List<Author>>() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                authorArrayList = (ArrayList<Author>) response.body();
                authorsView.refreshAuthorsList(authorArrayList);
                authorsOrNot(authorArrayList);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    public void searchAuthors(String author) {
        authorService.getAuthorsByName(author, new Callback<List<Author>>() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                authorArrayList = (ArrayList<Author>) response.body();
                authorsView.refreshAuthorsList(authorArrayList);
                authorsOrNot(authorArrayList);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    public void setView(AuthorsListContract.AuthorsView view) {
        this.authorsView = view;
    }

    private void authorsOrNot(ArrayList<Author> authors){
        boolean empty = false;
        if(authors.size() == 0) {
            empty = true;
        }

        authorsView.authorsEmpty(empty);
    }
}
