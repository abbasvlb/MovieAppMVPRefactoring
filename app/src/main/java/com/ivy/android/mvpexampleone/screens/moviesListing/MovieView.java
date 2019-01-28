package com.ivy.android.mvpexampleone.screens.moviesListing;

import com.ivy.android.mvpexampleone.screens.moviesListing.model.Movie;

import java.util.List;

public interface MovieView {
    public void updateUi(List<Movie> movies);
}
