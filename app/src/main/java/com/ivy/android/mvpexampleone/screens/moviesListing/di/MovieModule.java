package com.ivy.android.mvpexampleone.screens.moviesListing.di;

import com.ivy.android.mvpexampleone.apiConnector.APIConnector;
import com.ivy.android.mvpexampleone.apiConnector.APIConnectorImpl;
import com.ivy.android.mvpexampleone.screens.moviesListing.model.MovieInteractor;
import com.ivy.android.mvpexampleone.screens.moviesListing.model.MovieInteractorImpl;
import com.ivy.android.mvpexampleone.screens.moviesListing.presentor.MoviePresentor;
import com.ivy.android.mvpexampleone.screens.moviesListing.presentor.MoviePresentorImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieModule {

    @Provides
    public MovieInteractor providesBooksInteractor(MovieInteractorImpl movieInteractor) {
        return movieInteractor;
    }

    @Provides
    public MoviePresentor providesBooksPresentor(MoviePresentorImpl moviePresentor) {
        return moviePresentor;
    }

}
