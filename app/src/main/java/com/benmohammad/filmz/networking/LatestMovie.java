package com.benmohammad.filmz.networking;

import com.google.gson.annotations.SerializedName;

public class LatestMovie {

    @SerializedName("title")
    private String mTitle;

    @SerializedName("vote_average")
    private String mVoteAverage;

    @SerializedName("overview")
    private String mDescription;

    public String getTitle() {
        return mTitle;
    }

    public String getVoteAverage() {
        return mVoteAverage;
    }

    public String getDescription() {
        return mDescription;
    }
}
