package com.exemple.bookstore.Presenters;

import com.exemple.bookstore.Contracts.BookDetailContract;

/**
 * Created by Jonathan on 28/02/2016.
 */
public class BookDetailPresenterImp implements BookDetailContract.Presenter {

    private BookDetailContract.View bookView;

    public BookDetailPresenterImp(BookDetailContract.View bookView){
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
