package com.exemple.bookstore.Activities;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.exemple.bookstore.API.AuthorService;
import com.exemple.bookstore.API.BookService;
import com.exemple.bookstore.Adapters.AuthorRecyclerAdapter;
import com.exemple.bookstore.Bus.BusProvider;
import com.exemple.bookstore.Events.LoadAuthorsEvent;
import com.exemple.bookstore.Fragments.BooksFragment;
import com.exemple.bookstore.Fragments.CommentsFragment;
import com.exemple.bookstore.Models.Author;
import com.exemple.bookstore.R;
import com.exemple.bookstore.Utils.Tools;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView authorsRecycler;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private AuthorService authorService;

    private ArrayList<Author> authorArrayList;
    private AuthorRecyclerAdapter authorRecyclerAdapter;

    private BookService bookService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authorService = new AuthorService();
        bookService = new BookService();

        getAuthors();

        // authors list
        authorArrayList = new ArrayList<Author>();
        authorRecyclerAdapter = new AuthorRecyclerAdapter(this, authorArrayList);

        LinearLayoutManager layoutManagerAuthor = new LinearLayoutManager(this);
        layoutManagerAuthor.setOrientation(LinearLayoutManager.HORIZONTAL);

        authorsRecycler = (RecyclerView) findViewById(R.id.author_recycler);
        authorsRecycler.setLayoutManager(layoutManagerAuthor);
        authorsRecycler.setAdapter(authorRecyclerAdapter);

        if(Tools.readFromPreferences(this, "AuthorPosition", null) != null) {
            int position = Integer.valueOf(Tools.readFromPreferences(this, "AuthorPosition", null));
            authorsRecycler.scrollToPosition(position);
        }

        Fragment fragmentBook = new BooksFragment();
        FragmentManager fmBook = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionBook = fmBook.beginTransaction();
        fragmentTransactionBook.replace(R.id.fragment_book, fragmentBook);
        fragmentTransactionBook.commit();

        Fragment fragmentComment = new CommentsFragment();
        FragmentManager fmComment = getSupportFragmentManager();
        FragmentTransaction ftComment = fmComment.beginTransaction();
        ftComment.replace(R.id.fragment_comment, fragmentComment);
        ftComment.commit();

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        
        setSupportActionBar(toolbar); // set our own toolbar
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Tools.saveToPreferences(this, "AuthorPosition", "0");

    }

    private void getAuthors(){
        authorService.getAuthors(new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                authorArrayList = (ArrayList<Author>) response.body();
                BusProvider.getInstance().post(new LoadAuthorsEvent(authorArrayList));
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    /*private void getBookById(int id){
        bookService.getBookById(id, new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                Book aBook = (Book) response.body();
                Log.d(LOG_TAG, "book 0 author = " + aBook.getAuthor().getFirstname());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }*/


    @Subscribe
    public void onLoadAuthorsEvent(LoadAuthorsEvent event){
        authorsRecycler.setAdapter(new AuthorRecyclerAdapter(this, event.getListAuthors()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                callSearch(query);
                //if you want to collapse the searchview
                invalidateOptionsMenu();
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
                //Do searching
                Log.d(LOG_TAG, "query = " + query);

                Fragment fragmentBook = new BooksFragment();

                Bundle bunble = new Bundle();
                bunble.putString("search", query);
                fragmentBook.setArguments(bunble);

                FragmentManager fmBook = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionBook = fmBook.beginTransaction();
                fragmentTransactionBook.replace(R.id.fragment_book, fragmentBook);
                fragmentTransactionBook.commit();
            }
        });

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_search){
            Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
