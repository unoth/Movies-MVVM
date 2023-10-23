package com.unoth.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("v1.3/movie?token=DQ3MA9B-340482C-QNN6RVQ-66PCCWV&fields=rating.kp&search=7-10&sortField=votes.kp&sortType=-1&page=1&limit=5")
    Single<MovieResponse> loadMovies();
}
