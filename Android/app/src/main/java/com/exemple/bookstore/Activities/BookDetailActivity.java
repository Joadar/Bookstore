package com.exemple.bookstore.Activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.exemple.bookstore.Contracts.BookDetailContract;
import com.exemple.bookstore.Fragments.CommentsFragment;
import com.exemple.bookstore.Models.Book;
import com.exemple.bookstore.Presenters.BookDetailPresenterImp;
import com.exemple.bookstore.R;
import com.exemple.bookstore.Utils.CircleTransform;
import com.squareup.picasso.Picasso;

public class BookDetailActivity extends AppCompatActivity implements BookDetailContract.View, View.OnClickListener {

    private TextView bookTitle;
    private ImageView bookImage;
    private ImageView authorImage;
    private TextView bookDescription;
    private TextView authorName;
    private TextView bookPages;
    private TextView bookPublished;

    private Toolbar toolbar;
    private Book book;

    private BookDetailContract.Presenter bookPresenter;

    private GestureDetectorCompat mDetector;

    private int bookId;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        //getWindow().setStatusBarColor(Color.TRANSPARENT);

        bookTitle       = (TextView) findViewById(R.id.book_title);
        bookImage       = (ImageView) findViewById(R.id.book_image);
        bookDescription = (TextView) findViewById(R.id.book_description);
        authorName      = (TextView) findViewById(R.id.book_author);
        authorImage     = (ImageView) findViewById(R.id.author_image);
        bookPages       = (TextView) findViewById(R.id.book_pages);
        bookPublished   = (TextView) findViewById(R.id.book_published);

        Bundle bundle = getIntent().getExtras();
        book = bundle.getParcelable("book");

        bookId = bundle.getInt("book_id");

        bookPresenter = new BookDetailPresenterImp(this);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle(book.getTitle());

        setSupportActionBar(toolbar);
        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), "name");
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(book.getTitle());
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));

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

    @Override
    public void onClick(View v) {
        bookPresenter.onAuthorClick();
    }

    @Override
    public void showBookDetail() {
        Picasso.with(this)
                .load(book.getImage())
                .placeholder(R.drawable.no_image)
                .into(bookImage);

        bookTitle.setText(book.getTitle());
        bookDescription.setText(book.getDescription());
        bookPages.setText(String.valueOf(book.getPages()));
        bookPublished.setText(book.getPublished());

    }

    @Override
    public void showAuthor() {
        Picasso.with(this)
                .load(book.getAuthor().getImage())
                .transform(new CircleTransform())
                .into(authorImage);

        authorName.setText(book.getAuthor().getFirstname() + " " + book.getAuthor().getLastname());

        authorImage.setOnClickListener(this);

    }

    @Override
    public void showComments() {
        Fragment fragment = new CommentsFragment();
        Bundle b = new Bundle();
        b.putInt("book_id", bookId);
        fragment.setArguments(b);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_comment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void goToAuthor() {
        Intent intent = new Intent(this, AuthorDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("author_id", book.getAuthor().getId());
        bundle.putParcelable("author", book.getAuthor());
        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();
    }
}
