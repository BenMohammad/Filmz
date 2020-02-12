package com.benmohammad.filmz.screens;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.benmohammad.filmz.R;
import com.benmohammad.filmz.services.FragmentFrameWrapper;
import com.benmohammad.filmz.services.FragmentNavigator;

public class MainActivity extends BaseActivity implements FragmentFrameWrapper {

    private FragmentNavigator fragmentNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentNavigator = getControllerCompositionRoot().getFragmentNavigator();
    }


    @Override
    public FrameLayout getFragmentFrame() {
        return findViewById(R.id.main_fragment);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fragmentNavigator.navigateToLatestMovieScreen();
    }
}
