package com.benmohammad.filmz.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDBApi {

    @GET("/3/movie/popular")
    Call<Movie> getLatestMovies(@Query("api_key")String key);


}
