package com.unoth.movies;

import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("kp")
    private Double rating;

    public Double getRating() {
        return rating;
    }

    public Rating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rating='" + rating + '\'' +
                '}';
    }
}
