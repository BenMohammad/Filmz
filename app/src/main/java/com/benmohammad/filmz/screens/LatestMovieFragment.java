package com.benmohammad.filmz.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.benmohammad.filmz.R;
import com.benmohammad.filmz.adapters.LatestMovieAdapter;
import com.benmohammad.filmz.networking.FetchLatestMovieUseCase;
import com.benmohammad.filmz.networking.LatestMovie;
import com.benmohammad.filmz.networking.Movie;

public class LatestMovieFragment extends BaseFragment implements LatestMovieAdapter.Listener, FetchLatestMovieUseCase.Listener {

    private RecyclerView mRecyclerView;
    private FetchLatestMovieUseCase mFetchLatestMovieUseCase;
    private LatestMovieAdapter mLatesMovieAdapter;

    public static LatestMovieFragment newInstance() {
        LatestMovieFragment fragment = new LatestMovieFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_latest_movie, container, false);
        mRecyclerView = view.findViewById(R.id.latest_movie_recycler_view);
        mFetchLatestMovieUseCase = getControllerCompositionRoot().getFetchLatestMovieUseCase();
        mFetchLatestMovieUseCase.registerListener(this);
        mFetchLatestMovieUseCase.fetchLatestMovieAndNotify();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mRecyclerView.getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), linearLayoutManager.getOrientation());
        mLatesMovieAdapter = getControllerCompositionRoot().getLatestMovieAdapter(this);

        mRecyclerView.setAdapter(mLatesMovieAdapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        return view;
    }

    @Override
    public void onMovieItemClicked(LatestMovie movie) {
        Toast.makeText(getContext(), movie.getTitle(), Toast.LENGTH_SHORT).show();
        getControllerCompositionRoot().getFragmentNavigator().navigateToDetailsScreen(movie.getDescription());

    }

    @Override
    public void OnFetchLatestMovieSuccess(Movie movie) {
        mLatesMovieAdapter.bindMovie(movie.getLatestMovies());
    }

    @Override
    public void OnFetchLatestMovieFailure(String msg) {

    }
}
