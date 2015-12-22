package com.exemple.bookstore.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exemple.bookstore.API.CommentService;
import com.exemple.bookstore.Adapters.CommentRecyclerAdapter;
import com.exemple.bookstore.Bus.BusProvider;
import com.exemple.bookstore.Events.LoadCommentsEvent;
import com.exemple.bookstore.Events.SearchEvent;
import com.exemple.bookstore.Models.Comment;
import com.exemple.bookstore.R;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Jonathan on 07/12/2015.
 */

@SuppressWarnings("unchecked")
public class CommentsFragment extends Fragment {

    private CommentService          commentService;
    private RecyclerView            commentsRecycler;

    private ArrayList<Comment>      commentArrayList;
    private CommentRecyclerAdapter  commentRecyclerAdapter;

    private TextView                emptyMessage;

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comments, container, false);

        commentService  = new CommentService();
        emptyMessage    = (TextView) view.findViewById(R.id.empty_message);

        if(getArguments() != null){
            Bundle bundle = getArguments();
            Integer bookId = bundle.getInt("book_id");
            if(bookId != 0) {
                getCommentsFromBook(bookId);
            }
        } else {
            getComments();
        }

        // comments list
        commentArrayList = new ArrayList<>();
        commentRecyclerAdapter = new CommentRecyclerAdapter(getContext(), commentArrayList);

        LinearLayoutManager layoutManagerComment = new LinearLayoutManager(getContext());
        layoutManagerComment.setOrientation(LinearLayoutManager.HORIZONTAL);

        commentsRecycler = (RecyclerView) view.findViewById(R.id.comment_recycler);
        commentsRecycler.setLayoutManager(layoutManagerComment);
        commentsRecycler.setAdapter(commentRecyclerAdapter);

        return view;
    }

    private void commentsOrNot(ArrayList<Comment> comments){
        if(comments.size() == 0){
            commentsRecycler.setVisibility(View.GONE);
            emptyMessage.setVisibility(View.VISIBLE);
        } else {
            commentsRecycler.setVisibility(View.VISIBLE);
            emptyMessage.setVisibility(View.GONE);
        }
    }

    private void getComments(){
        commentService.getComments(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                commentArrayList = (ArrayList<Comment>) response.body();
                BusProvider.getInstance().post(new LoadCommentsEvent(commentArrayList));
                commentsOrNot(commentArrayList);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void getCommentsFromBook(int id){
        commentService.getCommentsByBook(id, new Callback<List<Comment>>() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                commentArrayList = (ArrayList<Comment>) response.body();
                BusProvider.getInstance().post(new LoadCommentsEvent(commentArrayList));
                commentsOrNot(commentArrayList);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void searchComments(String search){
        commentService.getCommentsByBookTitle(search, new Callback<List<Comment>>() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                commentArrayList = (ArrayList<Comment>) response.body();
                BusProvider.getInstance().post(new LoadCommentsEvent(commentArrayList));
                commentsOrNot(commentArrayList);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Subscribe
    public void onLoadCommentsEvent(LoadCommentsEvent event){
        commentsRecycler.setAdapter(new CommentRecyclerAdapter(getContext(), event.getListComments()));
    }

    @Subscribe
    public void onSearchEvent(SearchEvent event){
        if(event.getSearch() != null){
            searchComments(event.getSearch());
        } else {
            getComments();
        }
    }

}
