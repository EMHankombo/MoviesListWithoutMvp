package com.example.mainza1992.movieapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mainza1992.movieapi.model.MovieListModel;
import com.example.mainza1992.movieapi.model.Result;
import com.squareup.picasso.Picasso;

/**
 * Created by mainza1992 on 28/09/2017.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MoviesViewHolder> {

    private MovieListModel movieListModel;
    private int list_item_movie;
    private Context applicationContext;
    private final MainActivity.onClickListener listener;


    public static final String THUMB_URL = "https://image.tmdb.org/t/p/w100_and_h100_bestv2/";


    public MovieListAdapter(MovieListModel movieListModel, int list_item_movie, Context applicationContext, MainActivity.onClickListener listener) {
        this.movieListModel = movieListModel;
        this.list_item_movie = list_item_movie;
        this.applicationContext = applicationContext;
        this.listener = listener;
    }


    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(list_item_movie, null);
        return new MoviesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {

        holder.title.setText(movieListModel.getResults().get(position).getTitle());
        holder.bind(movieListModel.getResults().get(position), listener);



        Picasso.with(applicationContext)
                .load(THUMB_URL + movieListModel.getResults().get(position).getPosterPath())
                .resize(500, 250)
                .centerCrop()
                .into(holder.poster);


    }

    @Override
    public int getItemCount() {
        return movieListModel.getTotalResults();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder {

        TextView title, rating;
        ImageView poster;

        public MoviesViewHolder(View itemView) {
            super(itemView);


            title = (TextView) itemView.findViewById(R.id.title2);
            rating = (TextView) itemView.findViewById(R.id.rating);
            poster = (ImageView) itemView.findViewById(R.id.poster);


        }

        public void bind(final Result item, final MainActivity.onClickListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    listener.onItemClick(item);

                }

            });


        }
    }

}
