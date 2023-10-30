package com.unoth.movies;

import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("kp")
    private String rating;

    public String getRating() {
        return rating;
    }

    public Rating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rating='" + rating + '\'' +
                '}';
    }
}
