package com.ivy.android.mvpexampleone.di;

import com.ivy.android.mvpexampleone.MovieActivity;
import dagger.Component;

@Component(modules = MovieModule.class)
public interface AppComponent {
    void inject(MovieActivity activity);
}
