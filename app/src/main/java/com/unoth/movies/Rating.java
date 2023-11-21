package com.unoth.movies;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Rating implements Serializable {
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
