package com.benmohammad.filmz.services;

import com.benmohammad.filmz.screens.LatestMovieDetailsFragment;
import com.benmohammad.filmz.screens.LatestMovieFragment;

public class FragmentNavigator {

    private final FragmentFrameManager mFragmentFrameSwapper;

    public FragmentNavigator(FragmentFrameManager fragmentFrameSwapper) {
        this.mFragmentFrameSwapper = fragmentFrameSwapper;
    }


    public void navigateToDetailsScreen(String description) {
        mFragmentFrameSwapper.replaceFragment(LatestMovieDetailsFragment.newInstance(description));
    }

    public void navigateToLatestMovieScreen() {
        mFragmentFrameSwapper.replaceFragment(LatestMovieFragment.newInstance());
    }
}
