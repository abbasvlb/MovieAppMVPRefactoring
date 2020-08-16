package com.ivy.android.mvpexampleone.screens.moviesListing.di;

import com.ivy.android.mvpexampleone.screens.moviesListing.MovieActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;


@Subcomponent(modules = MovieModule.class)
public interface MovieComponent {
    void inject(MovieActivity activity);
}
