package com.exemple.bookstore.Presenters;

import com.exemple.bookstore.Contracts.BookContract;

/**
 * Created by Jonathan on 28/02/2016.
 */
public class BookPresenter implements BookContract.Presenter {

    private BookContract.View bookView;

    public BookPresenter(BookContract.View bookView){
        this.bookView = bookView;

        bookView.showBookDetail();
        bookView.showAuthor();
        bookView.showComments();
    }

    @Override
    public void onAuthorClick() {
        bookView.goToAuthor();
    }
}
