package com.exemple.bookstore.Contracts;

import com.exemple.bookstore.Presenters.Presenter;
import com.exemple.bookstore.Views.View;

/**
 * Created by Jonathan on 29/02/2016.
 */
public interface MainContract {

    interface MainView extends View {

    }

    interface MainPresenter extends Presenter<MainView> {

    }
}
