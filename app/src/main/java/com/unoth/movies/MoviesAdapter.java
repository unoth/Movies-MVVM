package com.unoth.movies;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {
    private final String textRatingFormat = "%.1f";

    private OnReachEndListener onReachEndListener;
    private OnMovieClickListener onMovieClickListener;

    public void setOnMovieClickListener(OnMovieClickListener onMovieClickListener) {
        this.onMovieClickListener = onMovieClickListener;
    }

    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }

    private List<Movie> movies = new ArrayList<>();

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    interface OnReachEndListener {
        void onReachEnd();
    }

    interface OnMovieClickListener {
        void onMovieClick(Movie movie);
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.movie_item,
                parent,
                false
        );
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        Log.d("MoviesAdapter", "onBindViewHolder: " + position);
        Movie movie = movies.get(position);
        Glide.with(holder.imgViewPoster)
                .load(movie.getPoster().getUrl())
                .into(holder.imgViewPoster);
        double rating = movie.getRating().getRating();
        int backgroundId;
        if (rating > 7) {
            backgroundId = R.drawable.circle_green;
        } else if (rating > 5) {
            backgroundId = R.drawable.circle_yellow;
        } else {
            backgroundId = R.drawable.circle_red;
        }
        Drawable drawable = ContextCompat.getDrawable(holder.itemView.getContext(), backgroundId);
        holder.textViewRating.setBackground(drawable);
        holder.textViewRating.setText(String.format(textRatingFormat, rating));
        if (position >= movies.size() - 10 && onReachEndListener != null) {
            onReachEndListener.onReachEnd();
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onMovieClickListener != null) {
                    onMovieClickListener.onMovieClick(movie);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MoviesViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgViewPoster;
        private final TextView textViewRating;

        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            imgViewPoster = itemView.findViewById(R.id.imgViewPoster);
            textViewRating = itemView.findViewById(R.id.textViewRating);
        }
    }
}
