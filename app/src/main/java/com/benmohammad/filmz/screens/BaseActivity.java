package com.benmohammad.filmz.screens;

import androidx.appcompat.app.AppCompatActivity;

import com.benmohammad.filmz.App;
import com.benmohammad.filmz.di.CompositionRoot;
import com.benmohammad.filmz.di.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getControllerCompositionRoot() {
        if(mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(
                    getCompositionRoot(), this
            );
        }

        return mControllerCompositionRoot;
    }

    private CompositionRoot getCompositionRoot() {
        return ((App) getApplication()).getCompositionRoot();
    }
}
