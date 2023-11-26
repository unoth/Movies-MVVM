package com.unoth.movies;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Trailer implements Serializable {
    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;

    public Trailer(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
