package com.exemple.bookstore.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.exemple.bookstore.Models.Comment;
import com.exemple.bookstore.R;

import java.util.ArrayList;

/**
 * Created by Jonathan on 05/12/2015.
 */
public class CommentRecyclerAdapter extends RecyclerView.Adapter<CommentRecyclerAdapter.CommentHolder> {

    private ArrayList<Comment> commentArrayList;
    private Context context;
    private LayoutInflater inflater;

    public CommentRecyclerAdapter(Context context, ArrayList<Comment> commentArrayList){
        this.context = context;
        this.commentArrayList = commentArrayList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_comment, parent, false);
        CommentHolder holder = new CommentHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(CommentHolder holder, int position) {
        Comment current = commentArrayList.get(position);

        holder.userUsername.setText(current.getUser().getUsername());
        holder.bookTitle.setText(current.getBook().getTitle());
        holder.commentContent.setText(current.getContent());
        holder.commentRating.setRating(current.getRating());
    }

    @Override
    public int getItemCount() {
        return commentArrayList.size();
    }

    public class CommentHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView userUsername;
        public TextView bookTitle;
        public TextView commentContent;
        public RatingBar commentRating;

        public CommentHolder(View itemView){
            super(itemView);

            userUsername = (TextView) itemView.findViewById(R.id.item_comment_user);
            bookTitle = (TextView) itemView.findViewById(R.id.item_comment_book);
            commentContent = (TextView) itemView.findViewById(R.id.item_comment_content);
            commentRating = (RatingBar) itemView.findViewById(R.id.ratingBar);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
