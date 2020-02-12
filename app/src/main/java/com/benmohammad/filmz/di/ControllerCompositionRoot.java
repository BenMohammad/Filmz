package com.benmohammad.filmz.di;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.benmohammad.filmz.adapters.LatestMovieAdapter;
import com.benmohammad.filmz.networking.FetchLatestMovieUseCase;
import com.benmohammad.filmz.networking.MovieDBApi;
import com.benmohammad.filmz.services.FragmentFrameManager;
import com.benmohammad.filmz.services.FragmentFrameWrapper;
import com.benmohammad.filmz.services.FragmentNavigator;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private final FragmentActivity mFragmentActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, FragmentActivity fragmentActivity) {
        this.mCompositionRoot = compositionRoot;
        this.mFragmentActivity = fragmentActivity;
    }

    private MovieDBApi getDarkSkyApi() {
        return mCompositionRoot.getMovieDBApi();
    }

    private FragmentActivity getActivity() {
        return mFragmentActivity;
    }

    private FragmentManager getFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }

    private FragmentFrameWrapper getFragmentFrameWrapper() {
        return (FragmentFrameWrapper) getActivity();
    }

    private FragmentFrameManager getFragmentFrameManager() {
        return new FragmentFrameManager(getFragmentManager(), getFragmentFrameWrapper());
    }

    public FetchLatestMovieUseCase getFetchLatestMovieUseCase() {
        return new FetchLatestMovieUseCase(getDarkSkyApi());
    }

    public FragmentNavigator getFragmentNavigator() {
        return new FragmentNavigator(getFragmentFrameManager());
    }

    public LatestMovieAdapter getLatestMovieAdapter(LatestMovieAdapter.Listener listener) {
        return new LatestMovieAdapter(listener);
    }
}
