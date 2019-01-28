package com.ivy.android.mvpexampleone.screens.moviesListing.model;

import com.ivy.android.mvpexampleone.apiConnector.MovieResponse;

import retrofit2.Call;

public interface MovieInteractor {

    Call<MovieResponse> fetch();
}
