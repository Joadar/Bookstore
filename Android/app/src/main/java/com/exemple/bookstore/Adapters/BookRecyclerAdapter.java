package com.exemple.bookstore.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.exemple.bookstore.Activities.BookDetailActivity;
import com.exemple.bookstore.Models.Book;
import com.exemple.bookstore.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Jonathan on 05/12/2015.
 */
public class BookRecyclerAdapter extends RecyclerView.Adapter<BookRecyclerAdapter.BookHolder> {

    private ArrayList<Book> bookArrayList;
    private Context context;
    private LayoutInflater inflater;

    public BookRecyclerAdapter(Context context, ArrayList<Book> bookArrayList){
        this.bookArrayList = bookArrayList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_book, parent, false);

        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        Book current = bookArrayList.get(position);

        Picasso.with(context)
                .load(current.getImage())
                .placeholder(R.drawable.no_image)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return bookArrayList.size();
    }

    public class BookHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView image;

        public BookHolder(View itemView){
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.item_book_image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, BookDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("book_id", bookArrayList.get(getAdapterPosition()).getId());
            bundle.putParcelable("book", bookArrayList.get(getAdapterPosition()));
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }
}
