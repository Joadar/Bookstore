package com.exemple.bookstore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.exemple.bookstore.Fragments.BooksFragment;
import com.exemple.bookstore.Models.Author;
import com.exemple.bookstore.R;

public class AuthorDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Author author;

    private TextView biography;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        biography = (TextView) findViewById(R.id.biography);

        Bundle bundle = getIntent().getExtras();

        Fragment fragment = new BooksFragment();

        if(bundle != null){
            Integer authorId = bundle.getInt("author_id");
            Bundle b = new Bundle();
            b.putInt("author_id", authorId);
            author = bundle.getParcelable("author");
            fragment.setArguments(b);
        }

        if(!author.getBiography().isEmpty()) {
            biography.setText(author.getBiography());
        } else {
            biography.setText("no biography");
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_book, fragment);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle(author.getFirstname() + " " + author.getLastname());

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            startActivity(new Intent(this, MainActivity.class));
            this.finish();
        }

        return true;
    }
}
