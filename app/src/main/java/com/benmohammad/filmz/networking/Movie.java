package com.benmohammad.filmz.networking;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("results")
    private List<LatestMovie> mLatestMovieList;

    public List<LatestMovie> getLatestMovies() {
        return mLatestMovieList;
    }
}
