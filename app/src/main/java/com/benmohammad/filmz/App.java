package com.benmohammad.filmz;

import android.app.Application;

import com.benmohammad.filmz.di.CompositionRoot;

public class App extends Application {

    private CompositionRoot mCompositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        mCompositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return mCompositionRoot;
    }
}
