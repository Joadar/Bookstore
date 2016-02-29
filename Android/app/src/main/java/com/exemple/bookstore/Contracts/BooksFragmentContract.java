package com.exemple.bookstore.Contracts;

import com.exemple.bookstore.Models.Book;

import java.util.ArrayList;

/**
 * Created by Jonathan on 28/02/2016.
 */
public interface BooksFragmentContract {

    interface View {

        void booksEmpty(Boolean empty);

        void refreshBooksList(ArrayList<Book> bookArrayList);
    }

    interface Presenter {

        void getBooks();

        void getBooksFromAuthor(int id);

        void searchBooks(String title);

    }
}
