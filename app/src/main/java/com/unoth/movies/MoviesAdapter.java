package com.unoth.movies;

import android.graphics.drawable.Drawable;
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

    private List<Movie> movies = new ArrayList<>();
    private String textRatingFormat = "%.1f";

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
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
