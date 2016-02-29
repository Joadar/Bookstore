package com.exemple.bookstore.Activities;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.exemple.bookstore.Contracts.MainContract;
import com.exemple.bookstore.Fragments.AuthorsFragment;
import com.exemple.bookstore.Fragments.BooksFragment;
import com.exemple.bookstore.Fragments.CommentsFragment;
import com.exemple.bookstore.Presenters.MainPresenterImp;
import com.exemple.bookstore.R;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private Toolbar toolbar;

    private MainPresenterImp mainPresenter;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenterImp();
        mainPresenter.setView(this);

        BooksFragment bFragment         = new BooksFragment();
        Fragment fragmentBook           = bFragment;
        FragmentManager fmBook          = getSupportFragmentManager();
        FragmentTransaction ftBook      = fmBook.beginTransaction();
        ftBook.replace(R.id.fragment_book, fragmentBook);
        ftBook.commit();

        mainPresenter.setBooksFragmentPresenter(bFragment);

        Fragment fragmentComment        = new CommentsFragment();
        FragmentManager fmComment       = getSupportFragmentManager();
        FragmentTransaction ftComment   = fmComment.beginTransaction();
        ftComment.replace(R.id.fragment_comment, fragmentComment);
        ftComment.commit();

        AuthorsFragment aFragment       = new AuthorsFragment();
        Fragment fragmentAuthor         = aFragment;
        FragmentManager fmAuthor        = getSupportFragmentManager();
        FragmentTransaction ftAuthor    = fmAuthor.beginTransaction();
        ftAuthor.replace(R.id.fragment_author, fragmentAuthor);
        ftAuthor.commit();

        mainPresenter.setAuthorsListPresenterImp(aFragment);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar); // set our own toolbar
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Tools.saveToPreferences(this, "AuthorPosition", "0");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Retrieve the SearchView and plug it into SearchManager
        SearchView searchView       = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                callSearch(query);
                //if you want to collapse the searchview
                //invalidateOptionsMenu();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //if (searchView.isExpanded() && TextUtils.isEmpty(newText)) {
                    //callSearch(newText);
                //}
                return true;
            }

            public void callSearch(String query) {
                // do searching
                Log.d(LOG_TAG, "query = " + query);
                mainPresenter.getBooksFragmentPresenter().searchBooks(query);
                mainPresenter.getAuthorsListPresenterImp().searchAuthors(query);
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Log.d("helloWorld", "onClose hitted");
                mainPresenter.getBooksFragmentPresenter().getBooks();
                mainPresenter.getAuthorsListPresenterImp().getAuthors();

                return false;
            }
        });

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
