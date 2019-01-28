package com.ivy.android.mvpexampleone.screens.moviesListing.presentor;

import com.ivy.android.mvpexampleone.screens.moviesListing.MovieView;

public interface MoviePresentor {
    public void performSearch();
    public void bindView(MovieView movieView);
    public void unbindView();
}
