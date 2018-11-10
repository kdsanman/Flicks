package com.codepath.flicks.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.flicks.R;
import com.codepath.flicks.models.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>{

    Context context;
    List<Movie> movies;

    public MoviesAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    //Responsible for inflating the item_movie xml
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Inflate the xml that we have -> item_movie.xml
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        return new ViewHolder(view);
    }

    //Take the data that lives in the position and put it in the view holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //Pull out the data that lives in that position
        Movie movie = movies.get(i);

        //Bind the data to the viewholder
        viewHolder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);

        }

        //Responsible for setting the data
        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());

            //Get Poster
            Glide.with(context).load(movie.getPosterPath()).into(ivPoster);
        }



    }
}
