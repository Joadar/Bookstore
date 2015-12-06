package com.exemple.bookstore.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.exemple.bookstore.Models.Author;
import com.exemple.bookstore.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Jonathan on 05/12/2015.
 */
public class AuthorRecyclerAdapter extends RecyclerView.Adapter<AuthorRecyclerAdapter.AuthorHolder> {

    private ArrayList<Author> authorArrayList;
    private Context context;
    private LayoutInflater inflater;

    public AuthorRecyclerAdapter(Context context, ArrayList<Author> authorArrayList){
        this.context = context;
        this.authorArrayList = authorArrayList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public AuthorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_author, parent, false);
        AuthorHolder holder = new AuthorHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(AuthorHolder holder, int position) {
        Author current = authorArrayList.get(position);

        holder.firstname.setText(current.getFirstname());
        holder.lastname.setText(current.getLastname());

        Picasso.with(context)
                .load(current.getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return authorArrayList.size();
    }

    public class AuthorHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView firstname;
        public TextView lastname;
        public ImageView image;

        public AuthorHolder(View itemView){
            super(itemView);
            firstname = (TextView) itemView.findViewById(R.id.item_author_firstname);
            lastname = (TextView) itemView.findViewById(R.id.item_author_lastname);
            image = (ImageView) itemView.findViewById(R.id.item_author_image);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
