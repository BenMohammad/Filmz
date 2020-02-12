package com.benmohammad.filmz.services;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentFrameManager {

    private final FragmentManager mFragmentManager;
    private final FragmentFrameWrapper mFragmentFrameWrapper;

    public FragmentFrameManager(FragmentManager fragmentManager, FragmentFrameWrapper fragmentFrameWrapper) {
        this.mFragmentManager = fragmentManager;
        this.mFragmentFrameWrapper = fragmentFrameWrapper;
    }

    public void replaceFragment(Fragment newFragment) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();

        if(mFragmentManager.getBackStackEntryCount() == 0) {
            ft.add(getFragmentId(), newFragment);
        } else {
            ft.replace(getFragmentId(), newFragment);
        }

        ft.addToBackStack(null);
        ft.commit();
    }

    private int getFragmentId() {
        return mFragmentFrameWrapper.getFragmentFrame().getId();
    }

}
