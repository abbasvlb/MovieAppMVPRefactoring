package com.ivy.android.mvpexampleone.model;

import com.ivy.android.mvpexampleone.model.MovieResponse;

import retrofit2.Call;

public interface MovieInteractor {

    Call<MovieResponse> fetch();
}
