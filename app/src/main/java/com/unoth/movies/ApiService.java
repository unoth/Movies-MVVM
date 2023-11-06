package com.unoth.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("v1.4/movie?token=DQ3MA9B-340482C-QNN6RVQ-66PCCWV&rating.kp=6-10&sortField=votes.kp&sortType=-1&limit=5")
    Single<MovieResponse> loadMovies(@Query("page") int page);
}
