package com.benmohammad.filmz.networking;

import com.benmohammad.filmz.common.Constants;

import java.util.HashSet;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchLatestMovieUseCase {

    public interface Listener {
        void OnFetchLatestMovieSuccess(Movie movie);
        void OnFetchLatestMovieFailure(String msg);
    }

    private Set<Listener> mListeners = new HashSet<>();
    private final MovieDBApi mMovieDBApi;

    public FetchLatestMovieUseCase(MovieDBApi movieDBApi) {
        this.mMovieDBApi = movieDBApi;
    }

    public void registerListener(Listener listener) {
        mListeners.add(listener);
    }

    public void unregisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    public void fetchLatestMovieAndNotify() {
        mMovieDBApi.getLatestMovies(Constants.MOVIEDB_API_KEY).enqueue(
                new Callback<Movie>() {
                    @Override
                    public void onResponse(Call<Movie> call, Response<Movie> response) {
                        if(response.isSuccessful()) {
                            notifySuccess(response.body());
                        } else {
                            notifyFailure(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<Movie> call, Throwable t) {
                        notifyFailure(t.getMessage());
                    }
                }
        );
    }

    public void notifySuccess(Movie movie) {
        for(Listener listener : mListeners) {
            listener.OnFetchLatestMovieSuccess(movie);
        }
    }

    public void notifyFailure(String msg) {
        for(Listener listener : mListeners) {
            listener.OnFetchLatestMovieFailure(msg);
        }
    }

}
