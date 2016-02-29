package com.exemple.bookstore.Contracts;

import com.exemple.bookstore.Models.Author;
import com.exemple.bookstore.Presenters.Presenter;
import com.exemple.bookstore.Views.View;

import java.util.ArrayList;

/**
 * Created by Jonathan on 29/02/2016.
 */
public interface AuthorsListContract {

    interface AuthorsView extends View {

        void authorsEmpty(boolean empty);

        void refreshAuthorsList(ArrayList<Author> authorArrayList);

    }

    interface AuthorsPresenter extends Presenter<AuthorsView> {

        void getAuthors();

        void searchAuthors(String author);

    }

}
