package com.ivy.android.mvpexampleone.presentor;

import com.ivy.android.mvpexampleone.MovieView;

public interface MoviePresentor {
    public void performSearch();
    public void bindView(MovieView movieView);
    public void unbindView();
}
