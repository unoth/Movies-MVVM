package com.unoth.movies;

import com.google.gson.annotations.SerializedName;

public class Poster {
    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public Poster(String url) {
        this.url = url;
    }
}
