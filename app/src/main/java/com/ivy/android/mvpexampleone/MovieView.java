package com.ivy.android.mvpexampleone;

import com.ivy.android.mvpexampleone.model.Movie;

import java.util.List;

public interface MovieView {
    public void updateUi(List<Movie> movies);
}
