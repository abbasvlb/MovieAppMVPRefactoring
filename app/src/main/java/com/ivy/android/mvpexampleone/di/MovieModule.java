package com.ivy.android.mvpexampleone.di;

import com.ivy.android.mvpexampleone.model.MovieInteractor;
import com.ivy.android.mvpexampleone.model.MovieInteractorImpl;
import com.ivy.android.mvpexampleone.presentor.MoviePresentor;
import com.ivy.android.mvpexampleone.presentor.MoviePresentorImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieModule {


    @Provides
    public MoviePresentor providesBooksPresentor() {
        return new MoviePresentorImpl(new MovieInteractorImpl("4c87c0fa03d00ee500e08763b0432f65"));
    }

}
