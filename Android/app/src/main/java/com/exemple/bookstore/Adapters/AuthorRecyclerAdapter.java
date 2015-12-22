package com.exemple.bookstore.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.exemple.bookstore.Activities.AuthorActivity;
import com.exemple.bookstore.Models.Author;
import com.exemple.bookstore.R;
import com.exemple.bookstore.Utils.Tools;
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

        return new AuthorHolder(view);
    }

    @Override
    public void onBindViewHolder(AuthorHolder holder, int position) {
        Author current = authorArrayList.get(position);

        holder.firstname.setText(current.getFirstname());
        holder.lastname.setText(current.getLastname());

        Picasso.with(context)
                .load(current.getImage())
                .placeholder(R.drawable.no_image)
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

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Tools.saveToPreferences(context, "AuthorPosition", String.valueOf(getAdapterPosition()));

            Intent intent = new Intent(context, AuthorActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("author_id", authorArrayList.get(getAdapterPosition()).getId());
            bundle.putParcelable("author", authorArrayList.get(getAdapterPosition()));
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }
}
