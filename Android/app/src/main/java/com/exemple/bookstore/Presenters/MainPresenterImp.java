package com.exemple.bookstore.Presenters;

import com.exemple.bookstore.Contracts.MainContract;
import com.exemple.bookstore.Fragments.AuthorsFragment;
import com.exemple.bookstore.Fragments.BooksFragment;

/**
 * Created by Jonathan on 29/02/2016.
 */
public class MainPresenterImp implements MainContract.MainPresenter{

    private MainContract.MainView mainView;

    private BooksListPresenterImp booksFragmentPresenter;
    private AuthorsListPresenterImp authorsListPresenterImp;

    public BooksListPresenterImp getBooksFragmentPresenter() {
        return booksFragmentPresenter;
    }

    public void setBooksFragmentPresenter(BooksFragment booksFragment) {
        this.booksFragmentPresenter = new BooksListPresenterImp();
        this.getBooksFragmentPresenter().setView(booksFragment);
    }

    public AuthorsListPresenterImp getAuthorsListPresenterImp() {
        return authorsListPresenterImp;
    }

    public void setAuthorsListPresenterImp(AuthorsFragment authorsFragment) {
        this.authorsListPresenterImp = new AuthorsListPresenterImp();
        this.getAuthorsListPresenterImp().setView(authorsFragment);
    }

    @Override
    public void setView(MainContract.MainView view) {
        this.mainView = view;
    }
}
