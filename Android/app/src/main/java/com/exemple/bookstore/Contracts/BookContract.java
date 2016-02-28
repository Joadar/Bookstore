package com.exemple.bookstore.Contracts;

/**
 * Created by Jonathan on 28/02/2016.
 */
public interface BookContract {

    interface View {

        void showBookDetail();

        void showAuthor();

        void showComments();

        void goToAuthor();

    }

    interface Presenter {

        void onAuthorClick();

    }
}
