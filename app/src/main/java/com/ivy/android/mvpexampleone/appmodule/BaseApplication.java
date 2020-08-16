package com.ivy.android.mvpexampleone.appmodule;

import android.app.Application;

import com.ivy.android.mvpexampleone.screens.moviesListing.di.MovieComponent;
import com.ivy.android.mvpexampleone.screens.moviesListing.di.MovieModule;

public class BaseApplication extends Application {
    private AppComponent appComponent;
    private MovieComponent movieComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();;
    }
    public AppComponent getAppComponent() {
        return appComponent;
    }

    public MovieComponent createMovieComponent() {
        movieComponent = appComponent.plus(new MovieModule());
        return movieComponent;
    }

    public void releaseDetailsComponent() {
        movieComponent = null;
    }


}