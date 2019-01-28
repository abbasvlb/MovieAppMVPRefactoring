package com.ivy.android.mvpexampleone.screens.moviesListing.model;

import com.ivy.android.mvpexampleone.apiConnector.APIConnector;
import com.ivy.android.mvpexampleone.apiConnector.MovieResponse;

import javax.inject.Inject;

import retrofit2.Call;

public class MovieInteractorImpl implements MovieInteractor {


    public APIConnector apiConnector;

    @Inject
    public MovieInteractorImpl(APIConnector apiConnector){
        this.apiConnector = apiConnector;
    }

    @Override
    public Call<MovieResponse> fetch() {
        return apiConnector.getAPIService().getTopRatedMovies(apiConnector.getAPIkey());

    }
}
