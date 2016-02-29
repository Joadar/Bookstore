package com.exemple.bookstore.Contracts;

import com.exemple.bookstore.Models.Book;
import com.exemple.bookstore.Presenters.Presenter;
import com.exemple.bookstore.Views.View;

import java.util.ArrayList;

/**
 * Created by Jonathan on 28/02/2016.
 */
public interface BooksListContract {

    interface BooksFragmentView extends View {

        void booksEmpty(Boolean empty);

        void refreshBooksList(ArrayList<Book> bookArrayList);
    }

    interface BooksFragmentPresenter extends Presenter<BooksFragmentView> {

        void getBooks();

        void getBooksFromAuthor(int id);

        void searchBooks(String title);

    }
}
