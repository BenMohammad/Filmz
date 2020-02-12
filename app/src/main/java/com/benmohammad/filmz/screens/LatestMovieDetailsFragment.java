package com.benmohammad.filmz.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.benmohammad.filmz.R;

import java.nio.BufferUnderflowException;

public class LatestMovieDetailsFragment extends BaseFragment {

    public static final String MOVIE_DESC_KEY = "MOVIE_DESC_KEY";
    private TextView mDescriptionTextView;

    public static LatestMovieDetailsFragment newInstance(String description) {
        LatestMovieDetailsFragment fragment = new LatestMovieDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MOVIE_DESC_KEY, description);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_latest_movie_description, container, false);
        mDescriptionTextView = view.findViewById(R.id.latest_movie_description_id);
        mDescriptionTextView.setText(getArguments().getString(LatestMovieDetailsFragment.MOVIE_DESC_KEY));

        return view;
    }
}


