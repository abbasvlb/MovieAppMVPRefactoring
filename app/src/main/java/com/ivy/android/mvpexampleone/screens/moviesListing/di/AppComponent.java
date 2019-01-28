package com.ivy.android.mvpexampleone.screens.moviesListing.di;

import com.ivy.android.mvpexampleone.screens.moviesListing.MovieActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MovieModule.class)
public interface AppComponent {
    void inject(MovieActivity activity);
}
