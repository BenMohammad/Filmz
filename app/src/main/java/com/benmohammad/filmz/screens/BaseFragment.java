package com.benmohammad.filmz.screens;

import androidx.fragment.app.Fragment;

import com.benmohammad.filmz.App;
import com.benmohammad.filmz.di.CompositionRoot;
import com.benmohammad.filmz.di.ControllerCompositionRoot;

public class BaseFragment extends Fragment {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getControllerCompositionRoot() {
        if(mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(getCompositionRoot(), requireActivity());
        }
        return mControllerCompositionRoot;
    }


    private CompositionRoot getCompositionRoot() {
        return((App) requireActivity().getApplication()).getCompositionRoot();
    }
}
